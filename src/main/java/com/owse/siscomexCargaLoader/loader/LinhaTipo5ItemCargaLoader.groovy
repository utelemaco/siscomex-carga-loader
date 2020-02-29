package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo5ItemCarga

class LinhaTipo5ItemCargaLoader {

    LinhaTipo5ItemCarga lineToObjetc(String line) {
        LinhaTipo5ItemCarga linhaTipo5ItemCarga = new LinhaTipo5ItemCarga()

        int token = 0
        linhaTipo5ItemCarga.tipoRegistro = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo5ItemCarga.numeroCEMercante = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.numeroItemCarga = line.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo5ItemCarga.codigoTipoItem = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo5ItemCarga.numeroConteiner = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo5ItemCarga.capacidadeConteiner = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.codigoTipoConteiner = line.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo5ItemCarga.tipoConteiner = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.taraConteiner = line.substring(token, token + 9)?.trim()
        token = token + 9

        linhaTipo5ItemCarga.indicadorUsoParcialConteiner = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo5ItemCarga.numeroLacreConteiner01 = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.numeroLacreConteiner02 = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.numeroLacreConteiner03 = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.numeroLacreConteiner04 = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo5ItemCarga.codigoTipoGranel = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.tipoGranel = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.quantidadeItensCargaSolta = line.substring(token, token + 7)?.trim()
        token = token + 7

        linhaTipo5ItemCarga.codigoTipoEmbalagemCargaSolta = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.tipoEmbalagemCargaSolta = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.numeroChassiVeiculo = line.substring(token, token + 30)?.trim()
        token = token + 30

        linhaTipo5ItemCarga.marcaVeiculo = line.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo5ItemCarga.contramarca = line.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo5ItemCarga.pesoBrutoItem = line.substring(token, token + 12)?.trim()
        token = token + 12

        linhaTipo5ItemCarga.cubagemItem = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo5ItemCarga.codigoMercadoriaPerigosa = line.substring(token, token + 6)?.trim()
        token = token + 6

        linhaTipo5ItemCarga.classeMercadoriaPerigosa = line.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo5ItemCarga.indicadorItemBloqueado = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo5ItemCarga.codigoBloqueioEscala01 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.descricaoBloqueioEscala01 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.codigoBloqueioEscala02 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.descricaoBloqueioEscala02 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.codigoBloqueioEscala03 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.descricaoBloqueioEscala03 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.codigoBloqueioEscala04 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo5ItemCarga.descricaoBloqueioEscala04 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo5ItemCarga.indicadorFimRegistro = line.substring(token, token + 1)?.trim()

        return linhaTipo5ItemCarga
    }
}
