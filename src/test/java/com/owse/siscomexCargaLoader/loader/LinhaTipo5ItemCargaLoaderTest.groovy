package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo5ItemCarga
import org.junit.Test

class LinhaTipo5ItemCargaLoaderTest {

    @Test
    public void test() {
        LinhaTipo5ItemCargaLoader loader  = new LinhaTipo5ItemCargaLoader()
        def line = '512190719214354600011GESU34206972022G0GENERAL PURPOSE(20\'/8\'6)-DRY 20\'                            002200000 HLD4586887                                                                                                                                                                                                                                                                                                                                 0000267330000000000009340                                                                                                                                                                                                                                                                   #'

        LinhaTipo5ItemCarga linhaTipo5ItemCarga = loader.lineToObjetc(line)
        assert linhaTipo5ItemCarga
        assert linhaTipo5ItemCarga.indicadorFimRegistro == '#'
    }
}
