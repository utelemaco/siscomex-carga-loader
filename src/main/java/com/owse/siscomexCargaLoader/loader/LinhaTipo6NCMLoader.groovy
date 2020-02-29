package com.owse.siscomexCargaLoader.loader


import com.owse.siscomexCargaLoader.raw.LinhaTipo6NCM

class LinhaTipo6NCMLoader {

    LinhaTipo6NCM lineToObjetc(String line) {
        LinhaTipo6NCM linhaTipo6NCM = new LinhaTipo6NCM()

        int token = 0

        linhaTipo6NCM.tipoRegistro = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo6NCM.numeroCEMercante = line.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo6NCM.numeroItemCarga = line.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo6NCM.codigoMercadoria = line.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo6NCM.descricaoMercadoria = line.substring(token, token + 140)?.trim()
        token = token + 140

        linhaTipo6NCM.indicadorFimRegistro = line.substring(token, token + 1)?.trim()

        return linhaTipo6NCM
    }
}
