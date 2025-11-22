package org.example.project

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Note
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.screens.HomeScreen
import org.example.project.screens.NoteScreen
import org.example.project.screens.ScannerScreen
import org.example.project.ui.theme.QrPlayTheme

@Composable
fun App() {
    // 1) Stop aux refs non résolues : on ne passe pas darkTheme manuellement,
    //    on laisse QrPlayTheme prendre la valeur système (ou, si tu veux forcer :)
    // val useDark = isSystemInDarkTheme()

    var currentTab by remember { mutableStateOf("Home") }

    QrPlayTheme /* (darkTheme = useDark) */ {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = currentTab == "Home",
                        onClick = { currentTab = "Home" },
                        icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = currentTab == "Scanner",
                        onClick = { currentTab = "Scanner" },
                        icon = { Icon(Icons.Filled.CameraAlt, contentDescription = null) },
                        label = { Text("Scanner") }
                    )
                    NavigationBarItem(
                        selected = currentTab == "Note",
                        onClick = { currentTab = "Note" },
                        icon = { Icon(Icons.AutoMirrored.Filled.Note, contentDescription = null) },
                        label = { Text("Note") }
                    )
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                when (currentTab) {
                    "Home" -> HomeScreen(
                        onOpenScanner = { currentTab = "Scanner" },  // 3) callbacks requis
                        onOpenNotes = { currentTab = "Note" }
                    )
                    "Scanner" -> ScannerScreen(
                        onBack = { currentTab = "Home" }              // 3) callback requis
                    )
                    "Note" -> NoteScreen(
                        onBack = { currentTab = "Home" }              // 3) callback requis
                    )
                }
            }
        }
    }
}
