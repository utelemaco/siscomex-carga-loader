package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo1EscalaRaw
import org.junit.Test

class LinhaTipo1EscalaLoaderTest {

    @Test
    public void test() {
        LinhaTipo1EscalaLoader loader  = new LinhaTipo1EscalaLoader()
        def line = '1190002914729351799   LOG-IN PANTANAL                                        2019090120190901                                                                                                                                                                                                                                                         271                     #'

        LinhaTipo1EscalaRaw linhaTipo1Escala = loader.lineToObjetc(line)
        assert linhaTipo1Escala
        assert linhaTipo1Escala.tipoRegistro == '1'
        assert linhaTipo1Escala.numeroEscala == '19000291472'
        assert linhaTipo1Escala.codigoIMOEmbarcacao == '9351799'
        assert linhaTipo1Escala.nomeEmbarcacao == 'LOG-IN PANTANAL'
        assert linhaTipo1Escala.dataPrevistaPrimeiraAtracacao == '20190901'
        assert linhaTipo1Escala.dataEfetivaPrimeiraAtracacao == '20190901'
        assert linhaTipo1Escala.numeroViagem == '271'
        assert linhaTipo1Escala.indicadorFimRegistro == '#'
    }
}
