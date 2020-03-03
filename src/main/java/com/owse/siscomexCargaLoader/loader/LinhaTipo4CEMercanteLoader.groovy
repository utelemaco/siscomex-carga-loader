package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo4CEMercanteRaw

class LinhaTipo4CEMercanteLoader {

    LinhaTipo4CEMercanteRaw lineToObjetc(String linhaArquivoOriginal) {
        LinhaTipo4CEMercanteRaw linhaTipo4CEMercante = new LinhaTipo4CEMercanteRaw()
        linhaTipo4CEMercante.linhaArquivoOriginal = linhaArquivoOriginal

        int token = 0
        
        linhaTipo4CEMercante.tipoRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1
        
        linhaTipo4CEMercante.numeroCEMercante = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15
        
        linhaTipo4CEMercante.numeroManifesto01 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto02 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto03 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto04 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto05 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto06 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto07 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto08 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto09 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.numeroManifesto10 = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.codigoTipoConhecimento = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.tipoConhecimento = linhaArquivoOriginal.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo4CEMercante.codigoCategoriaCarga = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.categoriaCarga = linhaArquivoOriginal.substring(token, token + 25)?.trim()
        token = token + 25

        linhaTipo4CEMercante.codigoSituacaoCarga = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.situacaoCarga = linhaArquivoOriginal.substring(token, token + 35)?.trim()
        token = token + 35

        linhaTipo4CEMercante.dataSituacaoCarga = linhaArquivoOriginal.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo4CEMercante.indicadorDisponibilidadeEntrega = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.numeroOriginalBL = linhaArquivoOriginal.substring(token, token + 18)?.trim()
        token = token + 18

        linhaTipo4CEMercante.numeroCEMaster = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo4CEMercante.cnpjAgenteDesconsolidador = linhaArquivoOriginal.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeAgenteDesconsolidador = linhaArquivoOriginal.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.cnpjEmpresaNavegacaoDesconsolidadora = linhaArquivoOriginal.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeEmpresaNavegacaoDesconsolidadora = linhaArquivoOriginal.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.cpfCnpjParteNotificada = linhaArquivoOriginal.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeParteNotificada = linhaArquivoOriginal.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.textoIdentificacaoParteNotificada = linhaArquivoOriginal.substring(token, token + 253)?.trim()
        token = token + 253

        linhaTipo4CEMercante.cpfCnpjConsignatarioCarga = linhaArquivoOriginal.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeConsignatarioCarga = linhaArquivoOriginal.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.indicadorConsignatarioCargaEstrangeiro = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.passaporteConsignatarioEstrangeiro = linhaArquivoOriginal.substring(token, token + 30)?.trim()
        token = token + 30

        linhaTipo4CEMercante.nomeConsignatarioEstrangeiro = linhaArquivoOriginal.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo4CEMercante.textoIdentificacaoConsignatarioEstrangeiro = linhaArquivoOriginal.substring(token, token + 253)?.trim()
        token = token + 253

        linhaTipo4CEMercante.cpfCnpjEmbarcador = linhaArquivoOriginal.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeEmbarcador = linhaArquivoOriginal.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.textoIdentificacaoEmbarcador = linhaArquivoOriginal.substring(token, token + 253)?.trim()
        token = token + 253

        linhaTipo4CEMercante.dataEmissaoCE = linhaArquivoOriginal.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo4CEMercante.textoDescricaoMercadoria = linhaArquivoOriginal.substring(token, token + 506)?.trim()
        token = token + 506

        linhaTipo4CEMercante.codigoPortoOrigemCarga = linhaArquivoOriginal.substring(token, token + 5)?.trim()
        token = token + 5

        linhaTipo4CEMercante.nomePortoOrigemCarga = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoPortoDestinoFinalCarga = linhaArquivoOriginal.substring(token, token + 5)?.trim()
        token = token + 5

        linhaTipo4CEMercante.nomePortoDestinoFinalCarga = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.cnpjAgenciaEmissoraCE = linhaArquivoOriginal.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo4CEMercante.nomeAgenciaEmissoraCE = linhaArquivoOriginal.substring(token, token + 115)?.trim()
        token = token + 115

        linhaTipo4CEMercante.numeroUltimoDocumentoDespachoCarga = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo4CEMercante.codigoTipoDocumentoDespacho = linhaArquivoOriginal.substring(token, token + 6)?.trim()
        token = token + 6

        linhaTipo4CEMercante.indicadorCargaBloqueada = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.codigoBloqueioEscala01 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.descricaoBloqueioEscala01 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoBloqueioEscala02 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.descricaoBloqueioEscala02 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoBloqueioEscala03 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.descricaoBloqueioEscala03 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoBloqueioEscala04 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.descricaoBloqueioEscala04 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.indicadorPracaEntregaExterior = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.codigoPaisEntregaCarga = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.nomePaisEntregaCarga = linhaArquivoOriginal.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo4CEMercante.indicadorBLServico = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo4CEMercante.numeroCEMercanteOriginalBLServico = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo4CEMercante.pesoBrutoCarga = linhaArquivoOriginal.substring(token, token + 12)?.trim()
        token = token + 12

        linhaTipo4CEMercante.cubagemCarga = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo4CEMercante.textoObservacores = linhaArquivoOriginal.substring(token, token + 253)?.trim()
        token = token + 253

        linhaTipo4CEMercante.numeroContainerShipConvenience01 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience02 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience03 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience04 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience05 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience06 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience07 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience08 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience09 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.numeroContainerShipConvenience10 = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo4CEMercante.codigoModalidadeFrete = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo4CEMercante.nomeModalidadeFrete = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo4CEMercante.codigoRecintoAduaneiroResponsavelDTSC = linhaArquivoOriginal.substring(token, token + 7)?.trim()
        token = token + 7

        linhaTipo4CEMercante.nomeRecintoAduaneiroResponsavelDTSC = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo4CEMercante.codigoUnidadeLocalDestinoFinalCarga = linhaArquivoOriginal.substring(token, token + 7)?.trim()
        token = token + 7

        linhaTipo4CEMercante.indicadorFimRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()

        return linhaTipo4CEMercante
    }
}
