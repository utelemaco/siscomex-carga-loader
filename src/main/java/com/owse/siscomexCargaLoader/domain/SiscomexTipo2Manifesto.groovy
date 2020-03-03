package com.owse.siscomexCargaLoader.domain

class SiscomexTipo2Manifesto {

    String linhaArquivoOriginal

    String numeroEscala
    String numeroManifesto
    String codigoPortoCarregamento
    String nomePortoCarregamento
    String codigoPortoDescarregamento
    String nomePortoDescarregamento
    String indicadorManifestoBloqueado
    String codigoBloqueioEscala01
    String descricaoBloqueioEscala01
    String codigoBloqueioEscala02
    String descricaoBloqueioEscala02
    String codigoBloqueioEscala03
    String descricaoBloqueioEscala03
    String codigoBloqueioEscala04
    String descricaoBloqueioEscala04
    String cnpjAgenciaNavegacaoResponsavelManifesto
    String nomeAgenciaNavegacaoResponsavelManifesto
    String codigoEmpresaNavegacaoResponsavelManifesto
    String nomeEmpresaNavegacaoResponsavelManifesto
    String codigoTipoTrafego
    String nomeTipoTrafego

    SiscomexTipo1Escala escala
    List<SiscomexTipo3ConteinerVazio> conteineresVazios = []
    List<SiscomexTipo4CEMercante> cesMercantes = []

}
