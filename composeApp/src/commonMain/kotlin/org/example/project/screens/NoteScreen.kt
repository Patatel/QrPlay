package org.example.project.screens

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.ui.AppScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    onBack: () -> Unit
) {
    val colors = MaterialTheme.colorScheme
    var note by remember { mutableStateOf("") }   // ✅ Stocke le texte de la note localement
    AppScaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notes", style = MaterialTheme.typography.titleLarge) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Retour")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colors.surface,
                    titleContentColor = colors.onSurface,
                    navigationIconContentColor = colors.onSurface
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),                      // ✅ Marges pour aérer
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("📝 Notes", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(16.dp))
                OutlinedTextField(                       // ✅ Champ de saisie stylisé Material 3
                    value = note,
                    onValueChange = { note = it },        // ✅ Met à jour la variable locale
                    label = { Text("Écris ta note ici") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(16.dp))
                Button(onClick = { println("Note sauvegardée: $note") }) {
                    Text("Sauvegarder")
                }
            }
        }
    }
}
