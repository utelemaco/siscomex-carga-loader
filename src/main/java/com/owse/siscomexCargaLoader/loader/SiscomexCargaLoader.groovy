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

        def ultimoCEMercanteMBL;
        arquivoSiscomexCarga.linhasTipo4CEMercante.each { linhaTipo4CEMercante ->
            if (linhaTipo4CEMercante.tipoConhecimento == 'BL') {
                linhaTipo4BLToSiscomexCEMercante(linhaTipo4CEMercante, siscomexEscala)
                return
            }

            if (linhaTipo4CEMercante.tipoConhecimento == 'MBL') {
                ultimoCEMercanteMBL = linhaTipo4MBLToSiscomexCEMercante(linhaTipo4CEMercante, siscomexEscala)
                return
            }

            if (linhaTipo4CEMercante.tipoConhecimento == 'HBL') {
                linhaTipo4HBLToSiscomexCEMercante(linhaTipo4CEMercante, ultimoCEMercanteMBL)
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
        SiscomexConteinerVazio siscomexConteinerVazio = new SiscomexConteinerVazio()
        copyProperties(linhaTipo3ConteinerVazio, siscomexConteinerVazio)
        siscomexConteinerVazio.manifesto = siscomexEscala.manifestos.find { it.numeroManifesto == siscomexConteinerVazio.numeroManifesto }
        siscomexConteinerVazio.manifesto?.conteineresVazios << siscomexConteinerVazio
    }

    void linhaTipo4BLToSiscomexCEMercante(LinhaTipo4CEMercante linhaTipo4CEMercanteBL, SiscomexEscala siscomexEscala) {
        SiscomexCEMercante ceMercanteBL = new SiscomexCEMercante()
        copyProperties(linhaTipo4CEMercanteBL, ceMercanteBL)
        ceMercanteBL.manifesto = siscomexEscala.manifestos.find { it.numeroManifesto == ceMercanteBL.ultimoNumeroManifesto }
        if(!ceMercanteBL.manifesto) {
            ceMercanteBL.manifesto = siscomexEscala.manifestos.find { it.numeroManifesto == ceMercanteBL.penultimoNumeroManifesto }
        }

        if (!ceMercanteBL.manifesto) {
            println "Warning processing CEMercante. Manifesto not found: numeroManifesto: ${ceMercanteBL.ultimoNumeroManifesto} or ${ceMercanteBL.penultimoNumeroManifesto}"
            return
        }
        ceMercanteBL.manifesto.cesMercantes << ceMercanteBL
    }

    SiscomexCEMercante linhaTipo4MBLToSiscomexCEMercante(LinhaTipo4CEMercante linhaTipo4CEMercanteMBL, SiscomexEscala siscomexEscala) {
        SiscomexCEMercante ceMercanteMBL = new SiscomexCEMercante()
        copyProperties(linhaTipo4CEMercanteMBL, ceMercanteMBL)
        ceMercanteMBL.manifesto = siscomexEscala.manifestos.find { it.numeroManifesto == ceMercanteMBL.ultimoNumeroManifesto }
        if (!ceMercanteMBL.manifesto) {
            println "Warning processing CEMercante. Manifesto not found: numeroManifesto: ${ceMercanteMBL.ultimoNumeroManifesto}"
            return
        }
        ceMercanteMBL.manifesto.cesMercantes << ceMercanteMBL
        return ceMercanteMBL
    }

    void linhaTipo4HBLToSiscomexCEMercante(LinhaTipo4CEMercante linhaTipo4CEMercanteHBL, SiscomexCEMercante ceMercanteMBL) {
        SiscomexCEMercante ceMercanteHBL = new SiscomexCEMercante()
        copyProperties(linhaTipo4CEMercanteHBL, ceMercanteHBL)
        ceMercanteHBL.ceMercanteMBL = ceMercanteMBL
        ceMercanteMBL.cesMercantesHBL << ceMercanteHBL
        ceMercanteHBL.manifesto = ceMercanteMBL.manifesto
        ceMercanteMBL.manifesto?.cesMercantes << ceMercanteHBL
    }

    void linhaTipo5ItemCargaToSiscomexItemCarga(LinhaTipo5ItemCarga linhaTipo5ItemCarga, SiscomexEscala siscomexEscala) {
        SiscomexItemCarga itemCarga = new SiscomexItemCarga()
        copyProperties(linhaTipo5ItemCarga, itemCarga)
        itemCarga.ceMercante = findCEMercante(itemCarga.numeroCEMercante, siscomexEscala)
        if (!itemCarga.ceMercante) {
            println "Warning processing ItemCarga. CEMercante not found: numeroCEMercante: ${itemCarga.numeroCEMercante}"
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
            return
        }
        ncm.itemCarga.ncms << ncm
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
