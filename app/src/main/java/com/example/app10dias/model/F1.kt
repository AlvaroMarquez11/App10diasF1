package com.example.app10dias.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class F1(
    @StringRes val equipo: Int,
    @StringRes val jefeEquipo: Int,
    @StringRes val piloto1: Int,
    @StringRes val piloto2: Int,
    @DrawableRes val escudo: Int,
    @DrawableRes val coche: Int,
    @ColorRes val colorFondoCarta: Int,
    @StringRes val link: Int,
    val numeroCampeonatosConstructores: Int,
    val numeroVictoriasPiloto1: Int,
    val numeroVictoriasPiloto2: Int
)


