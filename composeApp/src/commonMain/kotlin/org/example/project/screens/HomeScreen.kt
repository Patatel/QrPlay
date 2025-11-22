package org.example.project.screens

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.ui.AppScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onOpenScanner: () -> Unit,
    onOpenNotes: () -> Unit
) {
    val colors = MaterialTheme.colorScheme
    AppScaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Accueil", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colors.surface,
                    titleContentColor = colors.onSurface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // ✅ Écran d’accueil simple
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,  // ✅ Centre horizontalement
                verticalArrangement = Arrangement.Center              // ✅ Centre verticalement
            ) {
                Text(
                    "🏠 Bienvenue sur la page d’accueil !",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(Modifier.height(16.dp))                        // ✅ Espacement vertical
                Text("Ici tu pourras accéder à tes notes et scanner des QR codes.")
            }
        }
    }
}
