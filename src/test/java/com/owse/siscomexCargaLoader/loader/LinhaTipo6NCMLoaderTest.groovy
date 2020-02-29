package com.owse.siscomexCargaLoader.loader


import com.owse.siscomexCargaLoader.raw.LinhaTipo6NCM
import org.junit.Test

class LinhaTipo6NCMLoaderTest {

    @Test
    public void test() {
        LinhaTipo6NCMLoader loader  = new LinhaTipo6NCMLoader()
        def line = '612190719214354600016802    PEDRAS DE CANTARIA OU DE CONSTRUÇÃO (EXCETO DE ARDÓSIA) TRA-BALHADAS E OBRAS DESTAS PEDRAS, EXCETO AS DA POSIÇÃO 68.01;                     #'

        LinhaTipo6NCM linhaTipo6NCM = loader.lineToObjetc(line)
        assert linhaTipo6NCM
        assert linhaTipo6NCM.indicadorFimRegistro == '#'
    }
}
