package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.domain.SiscomexArquivoDTO
import com.owse.siscomexCargaLoader.domain.SiscomexCEMercanteDTO
import com.owse.siscomexCargaLoader.domain.SiscomexConteinerVazioDTO
import com.owse.siscomexCargaLoader.domain.SiscomexEscalaDTO
import com.owse.siscomexCargaLoader.domain.SiscomexItemCargaDTO
import com.owse.siscomexCargaLoader.domain.SiscomexManifestoDTO
import com.owse.siscomexCargaLoader.domain.SiscomexNCMDTO
import com.owse.siscomexCargaLoader.raw.ArquivoSiscomexCarga
import com.owse.siscomexCargaLoader.raw.LinhaTipo1Escala
import com.owse.siscomexCargaLoader.raw.LinhaTipo2Manifesto
import com.owse.siscomexCargaLoader.raw.LinhaTipo3ConteinerVazio
import com.owse.siscomexCargaLoader.raw.LinhaTipo4CEMercante
import com.owse.siscomexCargaLoader.raw.LinhaTipo5ItemCarga
import com.owse.siscomexCargaLoader.raw.LinhaTipo6NCM

class SiscomexCargaLoader {

    ArquivoSiscomexCargaLoader arquivoLoader = new ArquivoSiscomexCargaLoader()

    SiscomexArquivoDTO loadFromByteArray(byte[] fileContent) {
        ArquivoSiscomexCarga arquivoSiscomexCarga = arquivoLoader.loadFromByteArray(fileContent)

        SiscomexArquivoDTO siscomexArquivo = new SiscomexArquivoDTO()
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

    SiscomexEscalaDTO linhaTipo1ToSiscomexEscala(LinhaTipo1Escala linhaTipo1Escala) {
        SiscomexEscalaDTO escala = new SiscomexEscalaDTO()
        copyProperties(linhaTipo1Escala, escala)
        return escala
    }

    void linhaTipo2ToSiscomexManifesto(LinhaTipo2Manifesto linhaTipo2Manifesto, SiscomexArquivoDTO siscomexArquivo) {
        SiscomexManifestoDTO siscomexManifesto = new SiscomexManifestoDTO()
        copyProperties(linhaTipo2Manifesto, siscomexManifesto)
        siscomexManifesto.escala = siscomexArquivo.escala
        siscomexArquivo.escala.manifestos << siscomexManifesto
    }

    void linhaTipo3ToSiscomexConteinerVazio(LinhaTipo3ConteinerVazio linhaTipo3ConteinerVazio, SiscomexArquivoDTO siscomexArquivo) {
        SiscomexConteinerVazioDTO conteinerVazio = new SiscomexConteinerVazioDTO()
        copyProperties(linhaTipo3ConteinerVazio, conteinerVazio)
        conteinerVazio.manifesto = siscomexArquivo.escala.manifestos.find { it.numeroManifesto == conteinerVazio.numeroManifesto }
        if (!conteinerVazio.manifesto) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo3ConteinerVazio.linhaArquivoOriginal
            return
        }
        conteinerVazio.manifesto?.conteineresVazios << conteinerVazio
    }

    void linhaTipo4MasterToSiscomexCEMercante(LinhaTipo4CEMercante linhaTipo4CEMercanteBL, SiscomexArquivoDTO siscomexArquivo) {
        SiscomexCEMercanteDTO ceMercanteMaster = new SiscomexCEMercanteDTO()
        copyProperties(linhaTipo4CEMercanteBL, ceMercanteMaster)
        ceMercanteMaster.manifesto = findManifesto(ceMercanteMaster, siscomexArquivo.escala)

        if (!ceMercanteMaster.manifesto) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo4CEMercanteBL.linhaArquivoOriginal
            return
        }
        ceMercanteMaster.manifesto.cesMercantes << ceMercanteMaster
    }

    void linhaTipo4HouseToSiscomexCEMercante(LinhaTipo4CEMercante linhaTipo4CEMercanteHBL, SiscomexArquivoDTO siscomexArquivo) {
        SiscomexCEMercanteDTO ceMercanteHouse = new SiscomexCEMercanteDTO()
        copyProperties(linhaTipo4CEMercanteHBL, ceMercanteHouse)
        SiscomexCEMercanteDTO ceMercanteMaster = findCEMercante(ceMercanteHouse.numeroCEMaster, siscomexArquivo.escala)
        if (!ceMercanteMaster) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo4CEMercanteHBL.linhaArquivoOriginal
            return
        }
        ceMercanteHouse.ceMercanteMaster = ceMercanteMaster
        ceMercanteMaster.cesMercantesHouse << ceMercanteHouse
        ceMercanteHouse.manifesto = ceMercanteMaster.manifesto
        ceMercanteHouse.manifesto?.cesMercantes << ceMercanteHouse
    }

    void linhaTipo5ItemCargaToSiscomexItemCarga(LinhaTipo5ItemCarga linhaTipo5ItemCarga, SiscomexArquivoDTO siscomexArquivo) {
        SiscomexItemCargaDTO itemCarga = new SiscomexItemCargaDTO()
        copyProperties(linhaTipo5ItemCarga, itemCarga)
        itemCarga.ceMercante = findCEMercante(itemCarga.numeroCEMercante, siscomexArquivo.escala)
        if (!itemCarga.ceMercante) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo5ItemCarga.linhaArquivoOriginal
            return
        }
        itemCarga.ceMercante.itensCarga << itemCarga
    }

    void linhaTipo6NCMToSiscomexNCM(LinhaTipo6NCM linhaTipo6NCM, SiscomexArquivoDTO siscomexArquivo) {
        SiscomexNCMDTO ncm = new SiscomexNCMDTO()
        copyProperties(linhaTipo6NCM, ncm)
        ncm.itemCarga = findItemCarga(ncm.numeroCEMercante, ncm.numeroItemCarga, siscomexArquivo.escala)
        if (!ncm.itemCarga) {
            siscomexArquivo.linhasNaoVinculadas << linhaTipo6NCM.linhaArquivoOriginal
            return
        }
        ncm.itemCarga.ncms << ncm
    }

    SiscomexManifestoDTO findManifesto(SiscomexCEMercanteDTO ceMercante, SiscomexEscalaDTO escala) {
        for (String numeroManifesto: ceMercante.numerosManifestosValidos) {
            SiscomexManifestoDTO manifesto = escala.manifestos.find { it.numeroManifesto == numeroManifesto }
            if (manifesto) {
                return manifesto
            }
        }
    }

    SiscomexCEMercanteDTO findCEMercante(String numeroCEMercante, SiscomexEscalaDTO escala) {
        for (SiscomexManifestoDTO manifesto: escala.manifestos) {
            for (SiscomexCEMercanteDTO ceMercante: manifesto.cesMercantes) {
                if (ceMercante.numeroCEMercante == numeroCEMercante) {
                    return ceMercante
                }
            }
        }
    }

    SiscomexItemCargaDTO findItemCarga(String numeroCEMercante, String numeroItemCarga, SiscomexEscalaDTO escala) {
        for (SiscomexManifestoDTO manifesto: escala.manifestos) {
            for (SiscomexCEMercanteDTO ceMercante: manifesto.cesMercantes) {
                for (SiscomexItemCargaDTO itemCarga: ceMercante.itensCarga) {
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
