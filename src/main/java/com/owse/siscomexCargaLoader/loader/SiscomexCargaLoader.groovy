package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.domain.SiscomexCEMercante
import com.owse.siscomexCargaLoader.domain.SiscomexConteinerVazio
import com.owse.siscomexCargaLoader.domain.SiscomexEscala
import com.owse.siscomexCargaLoader.domain.SiscomexItemCarga
import com.owse.siscomexCargaLoader.domain.SiscomexManifesto
import com.owse.siscomexCargaLoader.domain.SiscomexNCM
import com.owse.siscomexCargaLoader.raw.ArquivoSiscomexCarga
import com.owse.siscomexCargaLoader.raw.LinhaTipo1Escala
import com.owse.siscomexCargaLoader.raw.LinhaTipo2Manifesto
import com.owse.siscomexCargaLoader.raw.LinhaTipo3ConteinerVazio
import com.owse.siscomexCargaLoader.raw.LinhaTipo4CEMercante
import com.owse.siscomexCargaLoader.raw.LinhaTipo5ItemCarga
import com.owse.siscomexCargaLoader.raw.LinhaTipo6NCM

class SiscomexCargaLoader {

    ArquivoSiscomexCargaLoader arquivoLoader = new ArquivoSiscomexCargaLoader()

    SiscomexEscala loadFromByteArray(byte[] fileContent) {
        ArquivoSiscomexCarga arquivoSiscomexCarga = arquivoLoader.loadFromByteArray(fileContent)

        SiscomexEscala siscomexEscala = linhaTipo1ToSiscomexEscala(arquivoSiscomexCarga.linhasTipo1Escala[0])

        arquivoSiscomexCarga.linhasTipo2Manifesto.each { linhaTipo2Manifesto ->
            linhaTipo2ToSiscomexManifesto(linhaTipo2Manifesto, siscomexEscala)
        }

        arquivoSiscomexCarga.linhasTipo3ConteinerVazio.each { linhaTipo3ConteinerVazio ->
            linhaTipo3ToSiscomexConteinerVazio(linhaTipo3ConteinerVazio, siscomexEscala)
        }

        arquivoSiscomexCarga.linhasTipo4CEMercante.each { linhaTipo4CEMercante ->
            if (linhaTipo4CEMercante.tipoConhecimento == 'BL' || linhaTipo4CEMercante.tipoConhecimento == 'MBL') {
                linhaTipo4MasterToSiscomexCEMercante(linhaTipo4CEMercante, siscomexEscala)
                return
            }

            if (linhaTipo4CEMercante.tipoConhecimento == 'MHBL' || linhaTipo4CEMercante.tipoConhecimento == 'HBL') {
                linhaTipo4HouseToSiscomexCEMercante(linhaTipo4CEMercante, siscomexEscala)
                return
            }
        }

        arquivoSiscomexCarga.linhasTipo5ItemCarga.each { linhaTipo5ItemCarga ->
            linhaTipo5ItemCargaToSiscomexItemCarga(linhaTipo5ItemCarga, siscomexEscala)
        }

        arquivoSiscomexCarga.linhasTipo6NCM.each { linhaTipo6NCM ->
            linhaTipo6NCMToSiscomexNCM(linhaTipo6NCM, siscomexEscala)
        }

        return siscomexEscala

    }

    SiscomexEscala linhaTipo1ToSiscomexEscala(LinhaTipo1Escala linhaTipo1Escala) {
        SiscomexEscala siscomexEscala = new SiscomexEscala()
        copyProperties(linhaTipo1Escala, siscomexEscala)
        return siscomexEscala
    }

    void linhaTipo2ToSiscomexManifesto(LinhaTipo2Manifesto linhaTipo2Manifesto, SiscomexEscala siscomexEscala) {
        SiscomexManifesto siscomexManifesto = new SiscomexManifesto()
        copyProperties(linhaTipo2Manifesto, siscomexManifesto)
        siscomexManifesto.escala = siscomexEscala
        siscomexEscala.manifestos << siscomexManifesto
    }

    void linhaTipo3ToSiscomexConteinerVazio(LinhaTipo3ConteinerVazio linhaTipo3ConteinerVazio, SiscomexEscala siscomexEscala) {
        SiscomexConteinerVazio conteinerVazio = new SiscomexConteinerVazio()
        copyProperties(linhaTipo3ConteinerVazio, conteinerVazio)
        conteinerVazio.manifesto = siscomexEscala.manifestos.find { it.numeroManifesto == conteinerVazio.numeroManifesto }
        if (!conteinerVazio.manifesto) {
            println "Warning processing ConteinerVazio. Manifesto not found: numeroManifesto: ${conteinerVazio.numeroManifesto}"
            siscomexEscala.conteinerVazioNaoVinculados << conteinerVazio
            return
        }
        conteinerVazio.manifesto?.conteineresVazios << conteinerVazio
    }

    void linhaTipo4MasterToSiscomexCEMercante(LinhaTipo4CEMercante linhaTipo4CEMercanteBL, SiscomexEscala siscomexEscala) {
        SiscomexCEMercante ceMercanteMaster = new SiscomexCEMercante()
        copyProperties(linhaTipo4CEMercanteBL, ceMercanteMaster)
        ceMercanteMaster.manifesto = findManifesto(ceMercanteMaster, siscomexEscala)

        if (!ceMercanteMaster.manifesto) {
            println "Warning processing CEMercante. Manifesto not found: numeroManifesto: ${ceMercanteMaster.numerosManifestosValidos}"
            siscomexEscala.cesMercantesNaoVinculados << ceMercanteMaster
            return
        }
        ceMercanteMaster.manifesto.cesMercantes << ceMercanteMaster
    }

    void linhaTipo4HouseToSiscomexCEMercante(LinhaTipo4CEMercante linhaTipo4CEMercanteHBL, SiscomexEscala siscomexEscala) {
        SiscomexCEMercante ceMercanteHouse = new SiscomexCEMercante()
        copyProperties(linhaTipo4CEMercanteHBL, ceMercanteHouse)
        SiscomexCEMercante ceMercanteMaster = findCEMercante(ceMercanteHouse.numeroCEMaster, siscomexEscala)
        if (!ceMercanteMaster) {
            println "Warning processing CEMercanteMaster. CEMercanteMaster not found: numeroCEMaster: ${ceMercanteHouse.numeroCEMaster}"
            siscomexEscala.cesMercantesNaoVinculados << ceMercanteHouse
            return
        }
        ceMercanteHouse.ceMercanteMaster = ceMercanteMaster
        ceMercanteMaster.cesMercantesHouse << ceMercanteHouse
        ceMercanteHouse.manifesto = ceMercanteMaster.manifesto
        ceMercanteHouse.manifesto?.cesMercantes << ceMercanteHouse
    }

    void linhaTipo5ItemCargaToSiscomexItemCarga(LinhaTipo5ItemCarga linhaTipo5ItemCarga, SiscomexEscala siscomexEscala) {
        SiscomexItemCarga itemCarga = new SiscomexItemCarga()
        copyProperties(linhaTipo5ItemCarga, itemCarga)
        itemCarga.ceMercante = findCEMercante(itemCarga.numeroCEMercante, siscomexEscala)
        if (!itemCarga.ceMercante) {
            println "Warning processing ItemCarga. CEMercante not found: numeroCEMercante: ${itemCarga.numeroCEMercante}"
            siscomexEscala.itensCargaNaoVinculados << itemCarga
            return
        }
        itemCarga.ceMercante.itensCarga << itemCarga
    }

    void linhaTipo6NCMToSiscomexNCM(LinhaTipo6NCM linhaTipo6NCM, SiscomexEscala siscomexEscala) {
        SiscomexNCM ncm = new SiscomexNCM()
        copyProperties(linhaTipo6NCM, ncm)
        ncm.itemCarga = findItemCarga(ncm.numeroCEMercante, ncm.numeroItemCarga, siscomexEscala)
        if (!ncm.itemCarga) {
            println "Warning processing NCM. ItemCarga not found: numeroCEMercante: ${ncm.numeroCEMercante} / numeroItemCarga: ${ncm.numeroItemCarga}"
            siscomexEscala.ncmsNaoVinculados << ncm
            return
        }
        ncm.itemCarga.ncms << ncm
    }

    SiscomexManifesto findManifesto(SiscomexCEMercante ceMercante, SiscomexEscala escala) {
        for (String numeroManifesto: ceMercante.numerosManifestosValidos) {
            SiscomexManifesto manifesto = escala.manifestos.find { it.numeroManifesto == numeroManifesto }
            if (manifesto) {
                return manifesto
            }
        }
    }

    SiscomexCEMercante findCEMercante(String numeroCEMercante, SiscomexEscala escala) {
        for (SiscomexManifesto manifesto: escala.manifestos) {
            for (SiscomexCEMercante ceMercante: manifesto.cesMercantes) {
                if (ceMercante.numeroCEMercante == numeroCEMercante) {
                    return ceMercante
                }
            }
        }
    }

    SiscomexItemCarga findItemCarga(String numeroCEMercante, String numeroItemCarga, SiscomexEscala escala) {
        for (SiscomexManifesto manifesto: escala.manifestos) {
            for (SiscomexCEMercante ceMercante: manifesto.cesMercantes) {
                for (SiscomexItemCarga itemCarga: ceMercante.itensCarga) {
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
