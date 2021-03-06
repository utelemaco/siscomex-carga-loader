package com.owse.siscomexCargaLoader.domain

class SiscomexTipo5ItemCarga {

    String linhaArquivoOriginal

    String numeroCEMercante
    String numeroItemCarga
    String codigoTipoItem
    String numeroConteiner
    String capacidadeConteiner
    String codigoTipoConteiner
    String tipoConteiner
    String taraConteiner
    String indicadorUsoParcialConteiner
    String numeroLacreConteiner01
    String numeroLacreConteiner02
    String numeroLacreConteiner03
    String numeroLacreConteiner04
    String codigoTipoGranel
    String tipoGranel
    String quantidadeItensCargaSolta
    String codigoTipoEmbalagemCargaSolta
    String tipoEmbalagemCargaSolta
    String numeroChassiVeiculo
    String marcaVeiculo
    String contramarca
    String pesoBrutoItem
    String cubagemItem
    String codigoMercadoriaPerigosa
    String classeMercadoriaPerigosa
    String indicadorItemBloqueado
    String codigoBloqueioEscala01
    String descricaoBloqueioEscala01
    String codigoBloqueioEscala02
    String descricaoBloqueioEscala02
    String codigoBloqueioEscala03
    String descricaoBloqueioEscala03
    String codigoBloqueioEscala04
    String descricaoBloqueioEscala04

    SiscomexTipo4CEMercante ceMercante
    List<SiscomexTipo6NCM> ncms = []

}
