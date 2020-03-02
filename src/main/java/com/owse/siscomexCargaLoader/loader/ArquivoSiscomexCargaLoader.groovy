package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.raw.ArquivoSiscomexCarga

class ArquivoSiscomexCargaLoader {

    LinhaTipo1EscalaLoader linhaTipo1EscalaLoader = new LinhaTipo1EscalaLoader()
    LinhaTipo2ManifestoLoader linhaTipo2ManifestoLoader = new LinhaTipo2ManifestoLoader()
    LinhaTipo3ConteinerVazioLoader linhaTipo3ConteinerVazioLoader = new LinhaTipo3ConteinerVazioLoader()
    LinhaTipo4CEMercanteLoader linhaTipo4CEMercanteLoader = new LinhaTipo4CEMercanteLoader()
    LinhaTipo5ItemCargaLoader linhaTipo5ItemCargaLoader = new LinhaTipo5ItemCargaLoader()
    LinhaTipo6NCMLoader linhaTipo6NCMLoader = new LinhaTipo6NCMLoader()

    ArquivoSiscomexCarga loadFromByteArray(byte[] fileContent) {
        ArquivoSiscomexCarga arquivoSiscomexCarga = new ArquivoSiscomexCarga()

        def is = new ByteArrayInputStream(fileContent)
        int lineNumber = 1;
        is.eachLine { linha ->
            try {
                if (linha.startsWith('1')) {
                    arquivoSiscomexCarga.linhasTipo1Escala << linhaTipo1EscalaLoader.lineToObjetc(linha)
                }

                if (linha.startsWith('2')) {
                    arquivoSiscomexCarga.linhasTipo2Manifesto << linhaTipo2ManifestoLoader.lineToObjetc(linha)
                }

                if (linha.startsWith('3')) {
                    arquivoSiscomexCarga.linhasTipo3ConteinerVazio << linhaTipo3ConteinerVazioLoader.lineToObjetc(linha)
                }

                if (linha.startsWith('4')) {
                    arquivoSiscomexCarga.linhasTipo4CEMercante << linhaTipo4CEMercanteLoader.lineToObjetc(linha)
                }

                if (linha.startsWith('5')) {
                    arquivoSiscomexCarga.linhasTipo5ItemCarga << linhaTipo5ItemCargaLoader.lineToObjetc(linha)
                }

                if (linha.startsWith('6')) {
                    arquivoSiscomexCarga.linhasTipo6NCM << linhaTipo6NCMLoader.lineToObjetc(linha)
                }
            } catch(Exception e) {
                println "Error processing line ${lineNumber}: ${e}"
            } finally {
                lineNumber++;
            }
        }
        is.close()

        return arquivoSiscomexCarga
    }
}
