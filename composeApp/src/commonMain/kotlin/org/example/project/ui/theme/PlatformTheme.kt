package org.example.project.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

/**
 * Déclaration commune : chaque plateforme fournit son "actual".
 */
expect object PlatformTheme {
    /**
     * @param base        schéma statique (light/dark) calculé en commun
     * @param darkTheme   true si mode sombre
     * @param dynamic     true pour tenter Material You (Android 12+)
     * @return ColorScheme à utiliser (peut être `base` tel quel)
     */
    @Composable
    fun colorScheme(base: ColorScheme, darkTheme: Boolean, dynamic: Boolean): ColorScheme
}
