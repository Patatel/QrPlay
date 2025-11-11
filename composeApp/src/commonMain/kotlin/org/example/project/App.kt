package org.example.project

// --- Import des composants Compose nécessaires ---
import androidx.compose.material3.*       // ✅ Composants Material 3 (Scaffold, BottomAppBar, etc.)
import androidx.compose.foundation.layout.* // ✅ Outils de mise en page (Row, Column, etc.)
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Note
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Note
import androidx.compose.runtime.*         // ✅ Gestion des états réactifs (remember, mutableStateOf, etc.)
import androidx.compose.ui.Alignment      // ✅ Alignement des éléments dans la mise en page
import androidx.compose.ui.Modifier       // ✅ Conteneur de modificateurs (padding, fillMaxSize, etc.)
import androidx.compose.ui.unit.dp        // ✅ Gestion des tailles en DP (Density-independent Pixels)
import org.example.project.screens.HomeScreen
import org.example.project.screens.NoteScreen
import org.example.project.screens.ScannerScreen

// --- Définition d'une fonction composable racine ---
@Composable
fun App() {                               // ✅ Point d’entrée principal de ton UI multiplateforme
    var currentTab by remember {           // ✅ Variable d’état : mémorise l’onglet sélectionné
        mutableStateOf("Home")             // ✅ Onglet par défaut : “Home”
    }

    // ✅ Structure principale Material 3
    Scaffold(
        bottomBar = {                      // ✅ Barre de navigation en bas d’écran
            BottomAppBar {
                // --- Boutons de navigation ---
                NavigationBarItem(
                    selected = currentTab == "Home",      // ✅ Vérifie si onglet actif
                    onClick = { currentTab = "Home" },    // ✅ Action au clic
                    icon = { Icon(Icons.Default.Home, null) },  // ✅ Icône de la page
                    label = { Text("Home") }              // ✅ Libellé
                )
                NavigationBarItem(
                    selected = currentTab == "Scanner",
                    onClick = { currentTab = "Scanner" },
                    icon = { Icon(Icons.Default.CameraAlt, null) },
                    label = { Text("Scanner") }
                )
                NavigationBarItem(
                    selected = currentTab == "Note",
                    onClick = { currentTab = "Note" },
                    icon = { Icon(Icons.Default.Note, null) },
                    label = { Text("Note") }
                )
            }
        }
    ) { paddingValues ->                   // ✅ “paddingValues” contient la zone sous la barre de navigation
        Box(
            modifier = Modifier
                .fillMaxSize()             // ✅ Remplit tout l’espace disponible
                .padding(paddingValues),   // ✅ Évite de recouvrir la bottom bar
            contentAlignment = Alignment.Center // ✅ Centre le contenu verticalement et horizontalement
        ) {
            // ✅ Affiche le contenu selon l’onglet actif
            when (currentTab) {
                "Home" -> HomeScreen()
                "Scanner" -> ScannerScreen()
                "Note" -> NoteScreen()
            }
        }
    }
}