package org.example.project.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

actual object PlatformTheme {
    @Composable
    actual fun colorScheme(base: ColorScheme, darkTheme: Boolean, dynamic: Boolean): ColorScheme {
        // Pas de couleurs dynamiques sur desktop : on renvoie le schéma de base
        return base
    }
}

