package com.vegcale.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = DarkColorPrimary,
    secondary = DarkColorSecondary,
    tertiary = DarkColorTertiary,
)

private val LightColorScheme = lightColorScheme(
    primary = LightColorPrimary,
    secondary = LightColorSecondary,
    tertiary = LightColorTertiary,
)

@Composable
fun ForWantedlyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}