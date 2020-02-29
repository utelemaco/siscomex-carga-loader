package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo4CEMercante

class LinhaTipo4CEMercanteLoader {

    LinhaTipo4CEMercante lineToObjetc(String line) {
        LinhaTipo4CEMercante linhaTipo4CEMercante = new LinhaTipo4CEMercante()

        int token = 0
        
        linhaTipo4CEMercante.tipoRegistro = line.substring(token, token + 1)?.trim()
        token = token + 1
        
        linhaTipo4CEMercante.numeroCEMercante = line.substring(token, token + 15)?.trim()
        token = token + 15
        
        linhaTipo4CEMercante.numeroManifesto01 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto02 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto03 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto04 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto05 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto06 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto07 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto08 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto09 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto10 = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.codigoTipoConhecimento = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.tipoConhecimento = line.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo4CEMercante.codigoCategoriaCarga = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.categoriaCarga = line.substring(token, token + 25)?.trim()
        token = token + 25

        linhaTipo4CEMercante.codigoSituacaoCarga = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.situacaoCarga = line.substring(token, token + 35)?.trim()
        token = token + 35

        linhaTipo4CEMercante.dataSituacaoCarga = line.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo4CEMercante.indicadorDisponibilidadeEntrega = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.numeroOriginalBL = line.substring(token, token + 18)?.trim()
        token = token + 18

        linhaTipo4CEMercante.numeroCEMaster = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo4CEMercante.cnpjAgenteDesconsolidador = line.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeAgenteDesconsolidador = line.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.cnpjEmpresaNavegacaoDesconsolidadora = line.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeEmpresaNavegacaoDesconsolidadora = line.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.cpfCnpjParteNotificada = line.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeParteNotificada = line.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.textoIdentificacaoParteNotificada = line.substring(token, token + 253)?.trim()
        token = token + 253

        linhaTipo4CEMercante.cpfCnpjConsignatarioCarga = line.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeConsignatarioCarga = line.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.indicadorConsignatarioCargaEstrangeiro = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.passaporteConsignatarioEstrangeiro = line.substring(token, token + 30)?.trim()
        token = token + 30

        linhaTipo4CEMercante.nomeConsignatarioEstrangeiro = line.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo4CEMercante.textoIdentificacaoConsignatarioEstrangeiro = line.substring(token, token + 253)?.trim()
        token = token + 253

        linhaTipo4CEMercante.cpfCnpjEmbarcador = line.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeEmbarcador = line.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.textoIdentificacaoEmbarcador = line.substring(token, token + 253)?.trim()
        token = token + 253

        linhaTipo4CEMercante.dataEmissaoCE = line.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo4CEMercante.textoDescricaoMercadoria = line.substring(token, token + 506)?.trim()
        token = token + 506

        linhaTipo4CEMercante.codigoPortoOrigemCarga = line.substring(token, token + 5)?.trim()
        token = token + 5

        linhaTipo4CEMercante.nomePortoOrigemCarga = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoPortoDestinoFinalCarga = line.substring(token, token + 5)?.trim()
        token = token + 5

        linhaTipo4CEMercante.nomePortoDestinoFinalCarga = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.cnpjAgenciaEmissoraCE = line.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeAgenciaEmissoraCE = line.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.numeroUltimoDocumentoDespachoCarga = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo4CEMercante.codigoTipoDocumentoDespacho = line.substring(token, token + 6)?.trim()
        token = token + 6

        linhaTipo4CEMercante.indicadorCargaBloqueada = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.codigoBloqueioEscala01 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.descricaoBloqueioEscala01 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoBloqueioEscala02 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.descricaoBloqueioEscala02 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoBloqueioEscala03 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.descricaoBloqueioEscala03 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoBloqueioEscala04 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.descricaoBloqueioEscala04 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.indicadorPracaEntregaExterior = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.codigoPaisEntregaCarga = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.nomePaisEntregaCarga = line.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo4CEMercante.indicadorBLServico = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.numeroCEMercanteOriginalBLServico = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo4CEMercante.pesoBrutoCarga = line.substring(token, token + 12)?.trim()
        token = token + 12

        linhaTipo4CEMercante.cubagemCarga = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.textoObservacores = line.substring(token, token + 253)?.trim()
        token = token + 253

        linhaTipo4CEMercante.numeroContainerShipConvenience01 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience02 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience03 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience04 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience05 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience06 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience07 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience08 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience09 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience10 = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.codigoModalidadeFrete = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.nomeModalidadeFrete = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo4CEMercante.codigoRecintoAduaneiroResponsavelDTSC = line.substring(token, token + 7)?.trim()
        token = token + 7

        linhaTipo4CEMercante.nomeRecintoAduaneiroResponsavelDTSC = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoUnidadeLocalDestinoFinalCarga = line.substring(token, token + 7)?.trim()
        token = token + 7

        linhaTipo4CEMercante.indicadorFimRegistro = line.substring(token, token + 1)?.trim()

        return linhaTipo4CEMercante
    }
}
