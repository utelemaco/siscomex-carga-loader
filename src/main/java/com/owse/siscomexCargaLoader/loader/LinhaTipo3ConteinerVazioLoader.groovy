package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo3ConteinerVazioRaw

class LinhaTipo3ConteinerVazioLoader {

    LinhaTipo3ConteinerVazioRaw lineToObjetc(String linhaArquivoOriginal) {
        LinhaTipo3ConteinerVazioRaw linhaTipo3ConteinerVazio = new LinhaTipo3ConteinerVazioRaw()
        linhaTipo3ConteinerVazio.linhaArquivoOriginal = linhaArquivoOriginal

        int token = 0

        linhaTipo3ConteinerVazio.tipoRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo3ConteinerVazio.numeroManifesto = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo3ConteinerVazio.identificacaoConteiner = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo3ConteinerVazio.capacidadeConteiner = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo3ConteinerVazio.codigoTipoConteiner = linhaArquivoOriginal.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo3ConteinerVazio.tipoConteiner = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo3ConteinerVazio.indicadorFimRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()

        return linhaTipo3ConteinerVazio
    }
}
