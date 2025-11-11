package org.example.project.screens

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    // ✅ Écran d’accueil simple
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,  // ✅ Centre horizontalement
        verticalArrangement = Arrangement.Center              // ✅ Centre verticalement
    ) {
        Text("🏠 Bienvenue sur la page d’accueil !", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))                        // ✅ Espacement vertical
        Text("Ici tu pourras accéder à tes notes et scanner des QR codes.")
    }
}
