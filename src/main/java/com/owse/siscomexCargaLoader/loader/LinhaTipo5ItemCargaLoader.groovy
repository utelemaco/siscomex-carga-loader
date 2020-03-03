package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo5ItemCargaRaw

class LinhaTipo5ItemCargaLoader {

    LinhaTipo5ItemCargaRaw lineToObjetc(String linhaArquivoOriginal) {
        LinhaTipo5ItemCargaRaw linhaTipo5ItemCarga = new LinhaTipo5ItemCargaRaw()
        linhaTipo5ItemCarga.linhaArquivoOriginal = linhaArquivoOriginal

        int token = 0
        linhaTipo5ItemCarga.tipoRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo5ItemCarga.numeroCEMercante = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.numeroItemCarga = linhaArquivoOriginal.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo5ItemCarga.codigoTipoItem = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo5ItemCarga.numeroConteiner = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo5ItemCarga.capacidadeConteiner = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.codigoTipoConteiner = linhaArquivoOriginal.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo5ItemCarga.tipoConteiner = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.taraConteiner = linhaArquivoOriginal.substring(token, token + 9)?.trim()
        token = token + 9

        linhaTipo5ItemCarga.indicadorUsoParcialConteiner = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo5ItemCarga.numeroLacreConteiner01 = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.numeroLacreConteiner02 = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.numeroLacreConteiner03 = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.numeroLacreConteiner04 = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.codigoTipoGranel = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.tipoGranel = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.quantidadeItensCargaSolta = linhaArquivoOriginal.substring(token, token + 7)?.trim()
        token = token + 7

        linhaTipo5ItemCarga.codigoTipoEmbalagemCargaSolta = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.tipoEmbalagemCargaSolta = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.numeroChassiVeiculo = linhaArquivoOriginal.substring(token, token + 30)?.trim()
        token = token + 30

        linhaTipo5ItemCarga.marcaVeiculo = linhaArquivoOriginal.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo5ItemCarga.contramarca = linhaArquivoOriginal.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo5ItemCarga.pesoBrutoItem = linhaArquivoOriginal.substring(token, token + 12)?.trim()
        token = token + 12

        linhaTipo5ItemCarga.cubagemItem = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo5ItemCarga.codigoMercadoriaPerigosa = linhaArquivoOriginal.substring(token, token + 6)?.trim()
        token = token + 6

        linhaTipo5ItemCarga.classeMercadoriaPerigosa = linhaArquivoOriginal.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo5ItemCarga.indicadorItemBloqueado = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo5ItemCarga.codigoBloqueioEscala01 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.descricaoBloqueioEscala01 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.codigoBloqueioEscala02 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.descricaoBloqueioEscala02 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.codigoBloqueioEscala03 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.descricaoBloqueioEscala03 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.codigoBloqueioEscala04 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.descricaoBloqueioEscala04 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.indicadorFimRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()

        return linhaTipo5ItemCarga
    }
}
