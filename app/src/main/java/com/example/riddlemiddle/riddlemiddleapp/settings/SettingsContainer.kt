package com.example.riddlemiddle.riddlemiddleapp.settings

import androidx.compose.ui.graphics.Color

data class SettingsContainer (
    val fontName: String,
    val fontSize: Int,
    val colorTheme1: ColorTheme,
    val colorTheme2: ColorTheme,
    val colorTheme3: ColorTheme,
)

data class ColorTheme (
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
)