package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo2Manifesto

class LinhaTipo2ManifestoLoader {

    LinhaTipo2Manifesto lineToObjetc(String line) {
        LinhaTipo2Manifesto linhaTipo2Manifesto = new LinhaTipo2Manifesto()

        int token = 0
        linhaTipo2Manifesto.tipoRegistro = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo2Manifesto.numeroEscala = line.substring(token, token + 11)?.trim()
        token = token + 11

        linhaTipo2Manifesto.numeroManifesto = line.substring(token, token + 13)?.trim()
        token = token + 13

        linhaTipo2Manifesto.codigoPortoCarregamento = line.substring(token, token + 5)?.trim()
        token = token + 5

        linhaTipo2Manifesto.nomePortoCarregamento = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoPortoDescarregamento = line.substring(token, token + 5)?.trim()
        token = token + 5

        linhaTipo2Manifesto.nomePortoDescarregamento = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.indicadorManifestoBloqueado = line.substring(token, token + 1)?.trim()
        token = token + 1

        linhaTipo2Manifesto.codigoBloqueioEscala01 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.descricaoBloqueioEscala01 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoBloqueioEscala02 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.descricaoBloqueioEscala02 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoBloqueioEscala03 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.descricaoBloqueioEscala03 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoBloqueioEscala04 = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.descricaoBloqueioEscala04 = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.cnpjAgenciaNavegacaoResponsavelManifesto = line.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo2Manifesto.nomeAgenciaNavegacaoResponsavelManifesto = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoEmpresaNavegacaoResponsavelManifesto = line.substring(token, token + 14)?.trim()
        token = token + 14

        linhaTipo2Manifesto.nomeEmpresaNavegacaoResponsavelManifesto = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.codigoTipoTrafego = line.substring(token, token + 2)?.trim()
        token = token + 2

        linhaTipo2Manifesto.nomeTipoTrafego = line.substring(token, token + 60)?.trim()
        token = token + 60

        linhaTipo2Manifesto.indicadorFimRegistro = line.substring(token, token + 1)?.trim()

        return linhaTipo2Manifesto
    }
}
