package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo3ConteinerVazioRaw
import org.junit.Test

class LinhaTipo3ConteinerVazioRawLoaderTest {

    @Test
    public void test() {
        LinhaTipo3ConteinerVazioLoader loader  = new LinhaTipo3ConteinerVazioLoader()
        def line = '31519B01728199SUDU66654034045G1HIGH CUBE (PASSIVE VENTS)(40\'/9\'6)                          #'

        LinhaTipo3ConteinerVazioRaw linhaTipo3ConteinerVazio = loader.lineToObjetc(line)
        assert linhaTipo3ConteinerVazio
        assert linhaTipo3ConteinerVazio.indicadorFimRegistro == '#'
    }
}
