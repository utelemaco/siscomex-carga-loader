package com.owse.siscomexCargaLoader.loader


import com.owse.siscomexCargaLoader.raw.LinhaTipo2Manifesto
import org.junit.Test

class LinhaTipo2ManifestoLoaderTest {

    @Test
    public void test() {
        LinhaTipo2ManifestoLoader loader  = new LinhaTipo2ManifestoLoader()
        def line = '2190002914721219B01717015BRRIORIO DE JANEIRO                                              BRVIXVITÓRIA                                                                                                                                                                                                                                                                                                              42581413000157LIBRA SERVICOS DE NAVEGACAO LTDA.                           DE001048      HAPAG LLOYD AKTIENGESELLSCHATT                              0BBALDEAÇÃO CARGA ESTRANGEIRA                                 #'

        LinhaTipo2Manifesto linhaTipo2Manifesto = loader.lineToObjetc(line)
        assert linhaTipo2Manifesto
        assert linhaTipo2Manifesto.indicadorFimRegistro == '#'
    }
}
