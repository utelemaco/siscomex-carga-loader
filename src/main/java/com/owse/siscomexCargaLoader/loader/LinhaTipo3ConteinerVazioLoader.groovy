package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo3ConteinerVazio

class LinhaTipo3ConteinerVazioLoader {

    LinhaTipo3ConteinerVazio lineToObjetc(String line) {
        LinhaTipo3ConteinerVazio linhaTipo3ConteinerVazio = new LinhaTipo3ConteinerVazio()

        int token = 0

        linhaTipo3ConteinerVazio.tipoRegistro = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo3ConteinerVazio.numeroManifesto = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo3ConteinerVazio.identificacaoConteiner = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo3ConteinerVazio.capacidadeConteiner = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo3ConteinerVazio.codigoTipoConteiner = line.substring(token, token + 4)?.trim()
        token = token + 4

        linhaTipo3ConteinerVazio.tipoConteiner = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo3ConteinerVazio.indicadorFimRegistro = line.substring(token, token + 1)?.trim()

        return linhaTipo3ConteinerVazio
    }
}
