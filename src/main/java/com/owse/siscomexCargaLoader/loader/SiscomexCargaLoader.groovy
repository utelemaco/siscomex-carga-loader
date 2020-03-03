package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.domain.SiscomexTipo0Arquivo
import com.owse.siscomexCargaLoader.domain.SiscomexTipo4CEMercante
import com.owse.siscomexCargaLoader.domain.SiscomexTipo3ConteinerVazio
import com.owse.siscomexCargaLoader.domain.SiscomexTipo1Escala
import com.owse.siscomexCargaLoader.domain.SiscomexTipo5ItemCarga
import com.owse.siscomexCargaLoader.domain.SiscomexTipo2Manifesto
import com.owse.siscomexCargaLoader.domain.SiscomexTipo6NCM
import com.owse.siscomexCargaLoader.raw.Tipo0ArquivoRaw
import com.owse.siscomexCargaLoader.raw.LinhaTipo1EscalaRaw
import com.owse.siscomexCargaLoader.raw.LinhaTipo2ManifestoRaw
import com.owse.siscomexCargaLoader.raw.LinhaTipo3ConteinerVazioRaw
import com.owse.siscomexCargaLoader.raw.LinhaTipo4CEMercanteRaw
import com.owse.siscomexCargaLoader.raw.LinhaTipo5ItemCargaRaw
import com.owse.siscomexCargaLoader.raw.LinhaTipo6NCMRaw

class SiscomexCargaLoader {

    ArquivoTipo0Loader arquivoLoader = new ArquivoTipo0Loader()

    SiscomexTipo0Arquivo loadFromByteArray(byte[] fileContent) {
        Tipo0ArquivoRaw arquivoSiscomexCarga = arquivoLoader.loadFromByteArray(fileContent)

        SiscomexTipo0Arquivo siscomexArquivo = new SiscomexTipo0Arquivo()
        siscomexArquivo.logProcessamento = arquivoSiscomexCarga.logProcessamento

        siscomexArquivo.escala = linhaTipo1ToSiscomexEscala(arquivoSiscomexCarga.linhasTipo1Escala[0])

        arquivoSiscomexCarga.linhasTipo2Manifesto.each { linhaTipo2Manifesto ->
            linhaTipo2ToSiscomexManifesto(linhaTipo2Manifesto, siscomexArquivo)
        }

        arquivoSiscomexCarga.linhasTipo3ConteinerVazio.each { linhaTipo3ConteinerVazio ->
            linhaTipo3ToSiscomexConteinerVazio(linhaTipo3ConteinerVazio, siscomexArquivo)
        }

        arquivoSiscomexCarga.linhasTipo4CEMercante.each { linhaTipo4CEMercante ->
            if (linhaTipo4CEMercante.tipoConhecimento == 'BL' || linhaTipo4CEMercante.tipoConhecimento == 'MBL') {
                linhaTipo4MasterToSiscomexCEMercante(linhaTipo4CEMercante, siscomexArquivo)
                return
            }

            if (linhaTipo4CEMercante.tipoConhecimento == 'MHBL' || linhaTipo4CEMercante.tipoConhecimento == 'HBL') {
                linhaTipo4HouseToSiscomexCEMercante(linhaTipo4CEMercante, siscomexArquivo)
                return
            }
        }

        arquivoSiscomexCarga.linhasTipo5ItemCarga.each { linhaTipo5ItemCarga ->
            linhaTipo5ItemCargaToSiscomexItemCarga(linhaTipo5ItemCarga, siscomexArquivo)
        }

        arquivoSiscomexCarga.linhasTipo6NCM.each { linhaTipo6NCM ->
            linhaTipo6NCMToSiscomexNCM(linhaTipo6NCM, siscomexArquivo)
        }

        if (siscomexArquivo.linhasNaoVinculadas) {
            siscomexArquivo.logProcessamento += "\nLinhas nao vinculadas:\n"
            siscomexArquivo.linhasNaoVinculadas.each {
                siscomexArquivo.logProcessamento += "${it}\n"
            }
        }

        return siscomexArquivo

    }

    SiscomexTipo1Escala linhaTipo1ToSiscomexEscala(LinhaTipo1EscalaRaw linhaTipo1Escala) {
        SiscomexTipo1Escala escala = new SiscomexTipo1Escala()
        if (linhaTipo1Escala) {
            copyProperties(linhaTipo1Escala, escala)
        }
        return escala
    }

    void linhaTipo2ToSiscomexManifesto(LinhaTipo2ManifestoRaw linhaTipo2Manifesto, SiscomexTipo0Arquivo siscomexArquivo) {
        SiscomexTipo2Manifesto siscomexManifesto = new SiscomexTipo2Manifesto()
        copyProperties(linhaTipo2Manifesto, siscomexManifesto)
        siscomexManifesto.escala = siscomexArquivo.escala
        siscomexArquivo.escala.manifestos << siscomexManifesto
    }

    void linhaTipo3ToSiscomexConteinerVazio(LinhaTipo3ConteinerVazioRaw linhaTipo3ConteinerVazio, SiscomexTipo0Arquivo siscomexArquivo) {
        SiscomexTipo3ConteinerVazio conteinerVazio = new SiscomexTipo3ConteinerVazio()
        copyProperties(linhaTipo3ConteinerVazio, conteinerVazio)
        conteinerVazio.manifesto = siscomexArquivo.escala.manifestos.find { it.numeroManifesto == conteinerVazio.numeroManifesto }
        if (!conteinerVazio.manifesto) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo3ConteinerVazio.linhaArquivoOriginal
            return
        }
        conteinerVazio.manifesto?.conteineresVazios << conteinerVazio
    }

    void linhaTipo4MasterToSiscomexCEMercante(LinhaTipo4CEMercanteRaw linhaTipo4CEMercanteBL, SiscomexTipo0Arquivo siscomexArquivo) {
        SiscomexTipo4CEMercante ceMercanteMaster = new SiscomexTipo4CEMercante()
        copyProperties(linhaTipo4CEMercanteBL, ceMercanteMaster)
        ceMercanteMaster.manifesto = findManifesto(ceMercanteMaster, siscomexArquivo.escala)

        if (!ceMercanteMaster.manifesto) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo4CEMercanteBL.linhaArquivoOriginal
            return
        }
        ceMercanteMaster.manifesto.cesMercantes << ceMercanteMaster
    }

    void linhaTipo4HouseToSiscomexCEMercante(LinhaTipo4CEMercanteRaw linhaTipo4CEMercanteHBL, SiscomexTipo0Arquivo siscomexArquivo) {
        SiscomexTipo4CEMercante ceMercanteHouse = new SiscomexTipo4CEMercante()
        copyProperties(linhaTipo4CEMercanteHBL, ceMercanteHouse)
        SiscomexTipo4CEMercante ceMercanteMaster = findCEMercante(ceMercanteHouse.numeroCEMaster, siscomexArquivo.escala)
        if (!ceMercanteMaster) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo4CEMercanteHBL.linhaArquivoOriginal
            return
        }
        ceMercanteHouse.ceMercanteMaster = ceMercanteMaster
        ceMercanteMaster.cesMercantesHouse << ceMercanteHouse
        ceMercanteHouse.manifesto = ceMercanteMaster.manifesto
        ceMercanteHouse.manifesto?.cesMercantes << ceMercanteHouse
    }

    void linhaTipo5ItemCargaToSiscomexItemCarga(LinhaTipo5ItemCargaRaw linhaTipo5ItemCarga, SiscomexTipo0Arquivo siscomexArquivo) {
        SiscomexTipo5ItemCarga itemCarga = new SiscomexTipo5ItemCarga()
        copyProperties(linhaTipo5ItemCarga, itemCarga)
        itemCarga.ceMercante = findCEMercante(itemCarga.numeroCEMercante, siscomexArquivo.escala)
        if (!itemCarga.ceMercante) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo5ItemCarga.linhaArquivoOriginal
            return
        }
        itemCarga.ceMercante.itensCarga << itemCarga
    }

    void linhaTipo6NCMToSiscomexNCM(LinhaTipo6NCMRaw linhaTipo6NCM, SiscomexTipo0Arquivo siscomexArquivo) {
        SiscomexTipo6NCM ncm = new SiscomexTipo6NCM()
        copyProperties(linhaTipo6NCM, ncm)
        ncm.itemCarga = findItemCarga(ncm.numeroCEMercante, ncm.numeroItemCarga, siscomexArquivo.escala)
        if (!ncm.itemCarga) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo6NCM.linhaArquivoOriginal
            return
        }
        ncm.itemCarga.ncms << ncm
    }

    SiscomexTipo2Manifesto findManifesto(SiscomexTipo4CEMercante ceMercante, SiscomexTipo1Escala escala) {
        for (String numeroManifesto: ceMercante.numerosManifestosValidos) {
            SiscomexTipo2Manifesto manifesto = escala.manifestos.find { it.numeroManifesto == numeroManifesto }
            if (manifesto) {
                return manifesto
            }
        }
    }

    SiscomexTipo4CEMercante findCEMercante(String numeroCEMercante, SiscomexTipo1Escala escala) {
        for (SiscomexTipo2Manifesto manifesto: escala.manifestos) {
            for (SiscomexTipo4CEMercante ceMercante: manifesto.cesMercantes) {
                if (ceMercante.numeroCEMercante == numeroCEMercante) {
                    return ceMercante
                }
            }
        }
    }

    SiscomexTipo5ItemCarga findItemCarga(String numeroCEMercante, String numeroItemCarga, SiscomexTipo1Escala escala) {
        for (SiscomexTipo2Manifesto manifesto: escala.manifestos) {
            for (SiscomexTipo4CEMercante ceMercante: manifesto.cesMercantes) {
                for (SiscomexTipo5ItemCarga itemCarga: ceMercante.itensCarga) {
                    if (itemCarga.numeroCEMercante == numeroCEMercante && itemCarga.numeroItemCarga == numeroItemCarga) {
                        return itemCarga
                    }
                }
            }
        }
    }

    void copyProperties(def source, def target) {
        source.properties.findAll{ it.key != 'class' && it.key != 'tipoRegistro' && it.key != 'indicadorFimRegistro' }.each {
            target."$it.key" = source."$it.key"
        }
    }
}
