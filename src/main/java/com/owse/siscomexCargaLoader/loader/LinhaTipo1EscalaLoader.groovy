package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo1EscalaRaw

class LinhaTipo1EscalaLoader {

    LinhaTipo1EscalaRaw lineToObjetc(String linhaArquivoOriginal) {
        LinhaTipo1EscalaRaw linhaTipo1Escala = new LinhaTipo1EscalaRaw()
        linhaTipo1Escala.linhaArquivoOriginal = linhaArquivoOriginal

        int token = 0
        linhaTipo1Escala.tipoRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo1Escala.numeroEscala = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo1Escala.codigoIMOEmbarcacao = linhaArquivoOriginal.substring(token, token + 10)?.trim()
        token = token + 10

        linhaTipo1Escala.nomeEmbarcacao = linhaArquivoOriginal.substring(token, token + 55)?.trim()
        token = token + 55

        linhaTipo1Escala.dataPrevistaPrimeiraAtracacao = linhaArquivoOriginal.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo1Escala.dataEfetivaPrimeiraAtracacao = linhaArquivoOriginal.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo1Escala.indicadorEscalaBloqueada = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo1Escala.codigoBloqueioEscala01 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo1Escala.descricaoBloqueioEscala01 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo1Escala.codigoBloqueioEscala02 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo1Escala.descricaoBloqueioEscala02 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo1Escala.codigoBloqueioEscala03 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo1Escala.descricaoBloqueioEscala03 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo1Escala.codigoBloqueioEscala04 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo1Escala.descricaoBloqueioEscala04 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo1Escala.numeroViagem = linhaArquivoOriginal.substring(token, token + 10)?.trim()
        token = token + 10

        linhaTipo1Escala.dataDeadlineSolicitarDTSC = linhaArquivoOriginal.substring(token, token + 8)?.trim()
        token = token + 8

        linhaTipo1Escala.horaDeadlineSolicitarDTSC = linhaArquivoOriginal.substring(token, token + 6)?.trim()
        token = token + 6

        linhaTipo1Escala.indicadorFimRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()

        return linhaTipo1Escala
    }
}
