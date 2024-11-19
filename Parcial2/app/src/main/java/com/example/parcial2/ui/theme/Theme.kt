package com.example.parcial2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1E88E5),
    secondary = Color(0xFF64B5F6),
    background = Color(0xFF121212),
    onPrimary = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1E88E5),
    secondary = Color(0xFF64B5F6),
    background = Color.White,
    onPrimary = Color.Black
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes(),
        content = content
    )
}
