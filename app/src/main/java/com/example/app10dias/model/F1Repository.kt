package com.example.app10dias.model

import com.example.app10dias.R


class F1Repository {
    fun getEquipos(): List<F1> {
        return listOf(
            F1(
                equipo = R.string.equipo1,
                jefeEquipo = R.string.principal1,
                piloto1 = R.string.pilotos1,
                piloto2 = R.string.pilotos1_1,
                escudo = R.drawable.redbull,
                coche = R.drawable.redbullcoche,
                colorFondoCarta = R.color.colorRedBull,
                colorFuente = R.color.white,
                link = R.string.link1,
                linkPresentation = R.string.link1_1,
                numeroCampeonatosConstructores = 6,
                numeroVictoriasPiloto1 = 54,
                numeroVictoriasPiloto2 = 6
            ),
            F1(
                equipo = R.string.equipo2,
                jefeEquipo = R.string.principal2,
                piloto1 = R.string.pilotos2,
                piloto2 = R.string.pilotos2_1,
                escudo = R.drawable.mercedes,
                coche = R.drawable.mercedescoche,
                colorFondoCarta = R.color.colorMercedes,
                colorFuente = R.color.white,
                link = R.string.link2,
                linkPresentation = R.string.link2_1,
                numeroCampeonatosConstructores = 8,
                numeroVictoriasPiloto1 = 103,
                numeroVictoriasPiloto2 = 1
            ),
            F1(
                equipo = R.string.equipo3,
                jefeEquipo = R.string.principal3,
                piloto1 = R.string.pilotos3,
                piloto2 = R.string.pilotos3_1,
                escudo = R.drawable.ferrari,
                coche = R.drawable.ferraricoche,
                colorFondoCarta = R.color.colorFerrari,
                colorFuente = R.color.white,
                link = R.string.link3,
                linkPresentation = R.string.link3_1,
                numeroCampeonatosConstructores = 16,
                numeroVictoriasPiloto1 = 5,
                numeroVictoriasPiloto2 = 2
            ),
            F1(
                equipo = R.string.equipo4,
                jefeEquipo = R.string.principal4,
                piloto1 = R.string.pilotos4,
                piloto2 = R.string.pilotos4_1,
                escudo = R.drawable.mclaren,
                coche = R.drawable.mclarencoche,
                colorFondoCarta = R.color.colorMClaren,
                colorFuente = R.color.black,
                link = R.string.link4,
                linkPresentation = R.string.link4_1,
                numeroCampeonatosConstructores = 8,
                numeroVictoriasPiloto1 = 0,
                numeroVictoriasPiloto2 = 0
            ),
            F1(
                equipo = R.string.equipo5,
                jefeEquipo = R.string.principal5,
                piloto1 = R.string.pilotos5,
                piloto2 = R.string.pilotos5_1,
                escudo = R.drawable.astonmartin,
                coche = R.drawable.astonmartincoche,
                colorFondoCarta = R.color.colorAstonMartin,
                colorFuente = R.color.white,
                link = R.string.link5,
                linkPresentation = R.string.link5_1,
                numeroCampeonatosConstructores = 0,
                numeroVictoriasPiloto1 = 32,
                numeroVictoriasPiloto2 = 0
            ),
            F1(
                equipo = R.string.equipo6,
                jefeEquipo = R.string.principal6,
                piloto1 = R.string.pilotos6,
                piloto2 = R.string.pilotos6_1,
                escudo = R.drawable.alpine,
                coche = R.drawable.alpinecoche,
                colorFondoCarta = R.color.colorAlpine,
                colorFuente = R.color.black,
                link = R.string.link6,
                linkPresentation = R.string.link6_1,
                numeroCampeonatosConstructores = 2,
                numeroVictoriasPiloto1 = 1,
                numeroVictoriasPiloto2 = 1
            ),
            F1(
                equipo = R.string.equipo7,
                jefeEquipo = R.string.principal7,
                piloto1 = R.string.pilotos7,
                piloto2 = R.string.pilotos7_1,
                escudo = R.drawable.williams,
                coche = R.drawable.williamscoche,
                colorFondoCarta = R.color.colorWilliams,
                colorFuente = R.color.white,
                link = R.string.link7,
                linkPresentation = R.string.link7_1,
                numeroCampeonatosConstructores = 9,
                numeroVictoriasPiloto1 = 0,
                numeroVictoriasPiloto2 = 0
            ),
            F1(
                equipo = R.string.equipo8,
                jefeEquipo = R.string.principal8,
                piloto1 = R.string.pilotos8,
                piloto2 = R.string.pilotos8_1,
                escudo = R.drawable.visarb,
                coche = R.drawable.alphatauricoche,
                colorFondoCarta = R.color.colorVisaRB,
                colorFuente = R.color.white,
                link = R.string.link8,
                linkPresentation = R.string.link8_1,
                numeroCampeonatosConstructores = 0,
                numeroVictoriasPiloto1 = 0,
                numeroVictoriasPiloto2 = 8
            ),
            F1(
                equipo = R.string.equipo9,
                jefeEquipo = R.string.principal9,
                piloto1 = R.string.pilotos9,
                piloto2 = R.string.pilotos9_1,
                escudo = R.drawable.stake,
                coche = R.drawable.stakecoche,
                colorFondoCarta = R.color.colorStake,
                colorFuente = R.color.white,
                link = R.string.link9,
                linkPresentation = R.string.link9_1,
                numeroCampeonatosConstructores = 0,
                numeroVictoriasPiloto1 = 10,
                numeroVictoriasPiloto2 = 0
            ),
            F1(
                equipo = R.string.equipo10,
                jefeEquipo = R.string.principal10,
                piloto1 = R.string.pilotos10,
                piloto2 = R.string.pilotos10_1,
                escudo = R.drawable.haas,
                coche = R.drawable.haascoche,
                colorFondoCarta = R.color.colorHaas,
                colorFuente = R.color.black,
                link = R.string.link10,
                linkPresentation = R.string.link10_1,
                numeroCampeonatosConstructores = 0,
                numeroVictoriasPiloto1 = 0,
                numeroVictoriasPiloto2 = 0
            )
        )
    }
}