package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.LinhaTipo3ConteinerVazio
import org.junit.Test

class LinhaTipo3ConteinerVazioLoaderTest {

    @Test
    public void test() {
        LinhaTipo3ConteinerVazioLoader loader  = new LinhaTipo3ConteinerVazioLoader()
        def line = '31519B01728199SUDU66654034045G1HIGH CUBE (PASSIVE VENTS)(40\'/9\'6)                          #'

        LinhaTipo3ConteinerVazio linhaTipo3ConteinerVazio = loader.lineToObjetc(line)
        assert linhaTipo3ConteinerVazio
        assert linhaTipo3ConteinerVazio.indicadorFimRegistro == '#'
    }
}
