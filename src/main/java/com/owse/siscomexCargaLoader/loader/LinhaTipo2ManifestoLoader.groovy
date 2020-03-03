package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo2ManifestoRaw

class LinhaTipo2ManifestoLoader {

    LinhaTipo2ManifestoRaw lineToObjetc(String linhaArquivoOriginal) {
        LinhaTipo2ManifestoRaw linhaTipo2Manifesto = new LinhaTipo2ManifestoRaw()
        linhaTipo2Manifesto.linhaArquivoOriginal = linhaArquivoOriginal

        int token = 0
        linhaTipo2Manifesto.tipoRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo2Manifesto.numeroEscala = linhaArquivoOriginal.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo2Manifesto.numeroManifesto = linhaArquivoOriginal.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo2Manifesto.codigoPortoCarregamento = linhaArquivoOriginal.substring(token, token + 5)?.trim()
        token = token + 5

        linhaTipo2Manifesto.nomePortoCarregamento = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoPortoDescarregamento = linhaArquivoOriginal.substring(token, token + 5)?.trim()
        token = token + 5

        linhaTipo2Manifesto.nomePortoDescarregamento = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.indicadorManifestoBloqueado = linhaArquivoOriginal.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo2Manifesto.codigoBloqueioEscala01 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.descricaoBloqueioEscala01 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoBloqueioEscala02 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.descricaoBloqueioEscala02 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoBloqueioEscala03 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.descricaoBloqueioEscala03 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoBloqueioEscala04 = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.descricaoBloqueioEscala04 = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.cnpjAgenciaNavegacaoResponsavelManifesto = linhaArquivoOriginal.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo2Manifesto.nomeAgenciaNavegacaoResponsavelManifesto = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoEmpresaNavegacaoResponsavelManifesto = linhaArquivoOriginal.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo2Manifesto.nomeEmpresaNavegacaoResponsavelManifesto = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoTipoTrafego = linhaArquivoOriginal.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.nomeTipoTrafego = linhaArquivoOriginal.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.indicadorFimRegistro = linhaArquivoOriginal.substring(token, token + 1)?.trim()

        return linhaTipo2Manifesto
    }
}
