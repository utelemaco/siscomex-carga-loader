package com.owse.siscomexCargaLoader.domain

class SiscomexEscala {

    String numeroEscala
    String codigoIMOEmbarcacao
    String nomeEmbarcacao
    String dataPrevistaPrimeiraAtracacao
    String dataEfetivaPrimeiraAtracacao
    String indicadorEscalaBloqueada
    String codigoBloqueioEscala01
    String descricaoBloqueioEscala01
    String codigoBloqueioEscala02
    String descricaoBloqueioEscala02
    String codigoBloqueioEscala03
    String descricaoBloqueioEscala03
    String codigoBloqueioEscala04
    String descricaoBloqueioEscala04
    String numeroViagem
    String dataDeadlineSolicitarDTSC
    String horaDeadlineSolicitarDTSC

    List<SiscomexManifesto> manifestos = []

    List<SiscomexConteinerVazio> conteinerVazioNaoVinculados = []
    List<SiscomexCEMercante> cesMercantesNaoVinculados = []
    List<SiscomexItemCarga> itensCargaNaoVinculados = []
    List<SiscomexNCM> ncmsNaoVinculados = []

}
