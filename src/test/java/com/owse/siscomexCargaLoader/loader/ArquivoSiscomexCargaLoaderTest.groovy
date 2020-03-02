package com.owse.siscomexCargaLoader.loader

import com.owse.siscomexCargaLoader.domain.SiscomexEscala
import com.owse.siscomexCargaLoader.raw.ArquivoSiscomexCarga
import org.junit.Test

class ArquivoSiscomexCargaLoaderTest {

    String fileContent = """40419031919016381519301725584                                                                                                                     10BL  NNACIONAL                 04CARREGADA                          20190902 6557                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             07201916001040ARAUJO CABRAL & ALVES LTDA                                                                                         N                                                                                                                                                                                                                                                                                                                                                  10524837000193LM - COMERCIO ATACADISTA DE MATERIAL DE CONSTRUCAO LTDA                                                            LM - COMERCIO LTDA - ME                                                                                                                                                                                                                                      201908281 CONTAINER DE 40HC DIZENDO CONTER 450 VOLUMES DE APPIA GRIGIO 60,60 VOLUMES DE PIETRA NATURALE,180 VOLUMES DE PL CER CREMA 60. NCM 6907                                                                                                                                                                                                                                                                                                                                                                                  BRVIXVITÓRIA                                                     BRPECPECEM                                                       42278291000124LOG-IN - LOGISTICA INTERMODAL S/A                                                                                                                                                                                                                                                                                                                                                                                                                          N               0000270981800000000000003VALOR COMERCIAL: 24184,71 DATA DE COLETA DA CARGA NO ARMAZEM DO EMBARCADOR: 28/08/2019                                                                                                                                                                                                                                                                                     HHHOUSE TO HOUSE                                                                    0317900#
504190319190163800011TCNU79961934045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          003880000 889879                                                                                                                                                                                                                                                                                                                                     0000270981800000000076000                                                                                                                                                                                                                                                                   #
604190319190163800016907    LADRILHOS E PLACAS (LAJES), PARA PAVIMENTAÇÃO OU REVESTIMEN-TO, DE CERÂMICA; CUBOS, PASTILHAS E ARTIGOS SEMELHANTES, PAR                    #
40419031919017191519301725584                                                                                                                     10BL  NNACIONAL                 04CARREGADA                          20190902 6558                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             05038925000145EUROTEXTIL COMERCIO E IMPORTACAO LTDA                                                                              N                                                                                                                                                                                                                                                                                                                                                  05038925000145EUROTEXTIL COMERCIO E IMPORTACAO LTDA                                                                              EUROTEXTIL COMERCIO E IMPORTACAO LTDA                                                                                                                                                                                                                        201908291 CONTAINER DE 40HC DIZENDO CONTER 478 VOLUMES DE RENDA LINGERIE VIENA 18CM 90POLIAMIDA 10ELASTANO 1. NCM 6002                                                                                                                                                                                                                                                                                                                                                                                                            BRVIXVITÓRIA                                                     BRPECPECEM                                                       42278291000124LOG-IN - LOGISTICA INTERMODAL S/A                                                                                                                                                                                                                                                                                                                                                                                                                          N               0000139682520000000000001AGENDAMENTO: 109927   VALOR COMERCIAL: 410759,55 DATA DE COLETA DA CARGA NO ARMAZEM DO EMBARCADOR: 29/08/2019                                                                                                                                                                                                                                                              HHHOUSE TO HOUSE                                                                    0317900#
504190319190171900011AMFU89151104045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          003880000 890137                                                                                                                                                                                                                                                                                                                                     0000139682520000000076000                                                                                                                                                                                                                                                                   #
604190319190171900016002    TECIDOS DE MALHA DE LARGURA NÃO SUPERIOR A 30CM, QUE CONTENHAM EM PESO, 5% OU MAIS DE FIOS DE ELASTÔMEROS OU DE FIOS DE                     #
2190002914721519301725584BRVIXVITÓRIA                                                     BRSSZSANTOS                                                                                                                                                                                                                                                                                                               42278291000124LOG-IN - LOGISTICA INTERMODAL S/A                           42278291000124LOG-IN - LOGISTICA INTERMODAL S/A                           03CABOTAGEM                                                   #
2190002914721519301725657BRVIXVITÓRIA                                                     BRSSZSANTOS                                                                                                                                                                                                                                                                                                               42278291000124LOG-IN - LOGISTICA INTERMODAL S/A                           42278291000124LOG-IN - LOGISTICA INTERMODAL S/A                           03CABOTAGEM                                                   #
31519301725657CAIU48323774045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657CAIU48384414045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657CAIU48407314045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657CAIU88106954045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657CAIU88117104045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657TCLU50113044045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657TCLU81724524045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657TCLU82874304045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657TCLU82931564045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657TCLU88077384045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
31519301725657TCNU86980224045G1HIGH CUBE (PASSIVE VENTS)(40'/9'6)                          #
1190002914729351799   LOG-IN PANTANAL                                        2019090120190901                                                                                                                                                                                                                                                         271                     #"""


    @Test
    public void testArquivoSiscomexCargaLoader() {
        ArquivoSiscomexCargaLoader loader  = new ArquivoSiscomexCargaLoader()

        ArquivoSiscomexCarga arquivoSiscomexCarga = loader.loadFromByteArray(fileContent.getBytes())
        assert arquivoSiscomexCarga
    }

    @Test
    public void testSiscomexCargaLoader() {
        SiscomexCargaLoader loader  = new SiscomexCargaLoader()

        SiscomexEscala escala = loader.loadFromByteArray(fileContent.getBytes())
        assert escala
    }

    @Test
    public void testFromFile () {
        File file = new File('/Users/utelemaco/Downloads/F_C079314127_D190903_H102708_M012.txt')
        println new Date()
        SiscomexCargaLoader loader  = new SiscomexCargaLoader()
        SiscomexEscala escala = loader.loadFromByteArray(file.getBytes())
        println new Date()
        int i = 1;
        println "${i++} Escala: ${escala.numeroEscala}"
        escala.manifestos.each { manifesto ->
            println "${i++}    Manifesto: ${manifesto.numeroManifesto}"
            manifesto.conteineresVazios.each { conteinerVazio ->
                println "${i++}         ConteinerVazio: ${conteinerVazio.identificacaoConteiner}"
            }

            manifesto.cesMercantes.each { ceMercante ->
                println "${i++}         CEMercante: ${ceMercante.tipoConhecimento}-${ceMercante.numeroCEMercante}"
                ceMercante.itensCarga.each { itemCarga ->
                    println "${i++}             ItemCarga: ${itemCarga.numeroItemCarga}"
                    itemCarga.ncms.each { ncm ->
                        println "${i++}                 NCM: ${ncm.codigoMercadoria}"
                    }
                }
            }
        }
        assert escala
    }
}
