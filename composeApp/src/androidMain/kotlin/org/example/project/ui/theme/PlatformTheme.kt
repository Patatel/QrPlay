package org.example.project.ui.theme

import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

actual object PlatformTheme {
    @Composable
    actual fun colorScheme(base: ColorScheme, darkTheme: Boolean, dynamic: Boolean): ColorScheme {
        if (!dynamic) return base
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) return base
        val ctx = LocalContext.current
        return if (darkTheme) dynamicDarkColorScheme(ctx) else dynamicLightColorScheme(ctx)
    }
}
