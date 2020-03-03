package com.owse.siscomexCargaLoader.loader


import com.owse.siscomexCargaLoader.raw.LinhaTipo6NCM

class LinhaTipo6NCMLoader {

    LinhaTipo6NCM lineToObjetc(String linhaArquivoOriginal) {
        LinhaTipo6NCM linhaTipo6NCM = new LinhaTipo6NCM()
        linhaTipo6NCM.linhaArquivoOriginal = linhaArquivoOriginal

        int token = 0

        linhaTipo6NCM.tipoRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo6NCM.numeroCEMercante = linhaArquivoOriginal.substring(token, token + 15)?.trim()
        token = token + 15

        linhaTipo6NCM.numeroItemCarga = linhaArquivoOriginal.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo6NCM.codigoMercadoria = linhaArquivoOriginal.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo6NCM.descricaoMercadoria = linhaArquivoOriginal.substring(token, token + 140)?.trim()
        token = token + 140

        linhaTipo6NCM.indicadorFimRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()

        return linhaTipo6NCM
    }
}
