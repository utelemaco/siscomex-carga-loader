package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo1Escala

class LinhaTipo1EscalaLoader {

    LinhaTipo1Escala lineToObjetc(String line) {
        LinhaTipo1Escala linhaTipo1Escala = new LinhaTipo1Escala()

        int token = 0
        linhaTipo1Escala.tipoRegistro = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo1Escala.numeroEscala = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo1Escala.codigoIMOEmbarcacao = line.substring(token, token + 10)?.trim()
        token = token + 10

        linhaTipo1Escala.nomeEmbarcacao = line.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo1Escala.dataPrevistaPrimeiraAtracacao = line.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo1Escala.dataEfetivaPrimeiraAtracacao = line.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo1Escala.indicadorEscalaBloqueada = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo1Escala.codigoBloqueioEscala01 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo1Escala.descricaoBloqueioEscala01 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo1Escala.codigoBloqueioEscala02 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo1Escala.descricaoBloqueioEscala02 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo1Escala.codigoBloqueioEscala03 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo1Escala.descricaoBloqueioEscala03 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo1Escala.codigoBloqueioEscala04 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo1Escala.descricaoBloqueioEscala04 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo1Escala.numeroViagem = line.substring(token, token + 10)?.trim()
        token = token + 10

        linhaTipo1Escala.dataDeadlineSolicitarDTSC = line.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo1Escala.horaDeadlineSolicitarDTSC = line.substring(token, token + 6)?.trim()
        token = token + 6

        linhaTipo1Escala.indicadorFimRegistro = line.substring(token, token + 1)?.trim()

        return linhaTipo1Escala
    }
}
