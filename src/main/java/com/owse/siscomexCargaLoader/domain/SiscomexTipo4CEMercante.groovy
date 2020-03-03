package com.owse.siscomexCargaLoader.domain

class SiscomexTipo4CEMercante {

    String linhaArquivoOriginal

    String numeroCEMercante
    String numeroManifesto01
    String numeroManifesto02
    String numeroManifesto03
    String numeroManifesto04
    String numeroManifesto05
    String numeroManifesto06
    String numeroManifesto07
    String numeroManifesto08
    String numeroManifesto09
    String numeroManifesto10
    String codigoTipoConhecimento
    String tipoConhecimento
    String codigoCategoriaCarga
    String categoriaCarga
    String codigoSituacaoCarga
    String situacaoCarga
    String dataSituacaoCarga
    String indicadorDisponibilidadeEntrega
    String numeroOriginalBL
    String numeroCEMaster
    String cnpjAgenteDesconsolidador
    String nomeAgenteDesconsolidador
    String cnpjEmpresaNavegacaoDesconsolidadora
    String nomeEmpresaNavegacaoDesconsolidadora
    String cpfCnpjParteNotificada
    String nomeParteNotificada
    String textoIdentificacaoParteNotificada
    String cpfCnpjConsignatarioCarga
    String nomeConsignatarioCarga
    String indicadorConsignatarioCargaEstrangeiro
    String passaporteConsignatarioEstrangeiro
    String nomeConsignatarioEstrangeiro
    String textoIdentificacaoConsignatarioEstrangeiro
    String cpfCnpjEmbarcador
    String nomeEmbarcador
    String textoIdentificacaoEmbarcador
    String dataEmissaoCE
    String textoDescricaoMercadoria
    String codigoPortoOrigemCarga
    String nomePortoOrigemCarga
    String codigoPortoDestinoFinalCarga
    String nomePortoDestinoFinalCarga
    String cnpjAgenciaEmissoraCE
    String nomeAgenciaEmissoraCE
    String numeroUltimoDocumentoDespachoCarga
    String codigoTipoDocumentoDespacho
    String indicadorCargaBloqueada
    String codigoBloqueioEscala01
    String descricaoBloqueioEscala01
    String codigoBloqueioEscala02
    String descricaoBloqueioEscala02
    String codigoBloqueioEscala03
    String descricaoBloqueioEscala03
    String codigoBloqueioEscala04
    String descricaoBloqueioEscala04
    String indicadorPracaEntregaExterior
    String codigoPaisEntregaCarga
    String nomePaisEntregaCarga
    String indicadorBLServico
    String numeroCEMercanteOriginalBLServico
    String pesoBrutoCarga
    String cubagemCarga
    String textoObservacores
    String numeroContainerShipConvenience01
    String numeroContainerShipConvenience02
    String numeroContainerShipConvenience03
    String numeroContainerShipConvenience04
    String numeroContainerShipConvenience05
    String numeroContainerShipConvenience06
    String numeroContainerShipConvenience07
    String numeroContainerShipConvenience08
    String numeroContainerShipConvenience09
    String numeroContainerShipConvenience10
    String codigoModalidadeFrete
    String nomeModalidadeFrete
    String codigoRecintoAduaneiroResponsavelDTSC
    String nomeRecintoAduaneiroResponsavelDTSC
    String codigoUnidadeLocalDestinoFinalCarga

    SiscomexTipo2Manifesto manifesto
    SiscomexTipo4CEMercante ceMercanteMaster
    List<SiscomexTipo4CEMercante> cesMercantesHouse = []
    List<SiscomexTipo5ItemCarga> itensCarga = []

    List<String> getNumerosManifestosValidos() {
        List<String> numerosManifestosValidos = []
        if (numeroManifesto10) {
            numerosManifestosValidos << numeroManifesto10
        }

        if (numeroManifesto09) {
            numerosManifestosValidos << numeroManifesto09
        }

        if (numeroManifesto08) {
            numerosManifestosValidos << numeroManifesto08
        }

        if (numeroManifesto07) {
            numerosManifestosValidos << numeroManifesto07
        }

        if (numeroManifesto06) {
            numerosManifestosValidos << numeroManifesto06
        }

        if (numeroManifesto05) {
            numerosManifestosValidos << numeroManifesto05
        }

        if (numeroManifesto04) {
            numerosManifestosValidos << numeroManifesto04
        }

        if (numeroManifesto03) {
            numerosManifestosValidos << numeroManifesto03
        }

        if (numeroManifesto02) {
            numerosManifestosValidos << numeroManifesto02
        }

        if (numeroManifesto01) {
            numerosManifestosValidos << numeroManifesto01
        }

        return numerosManifestosValidos
    }

}
