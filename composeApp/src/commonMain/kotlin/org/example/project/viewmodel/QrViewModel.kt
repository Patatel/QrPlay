package org.example.project.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel simplifié (aucune dépendance Android, fonctionne sur Desktop et Android)
 * Servira plus tard à gérer l’état du scanner, la liste de notes, etc.
 */
class QrViewModel {

    // ✅ Exemple d’état réactif (Flow)
    private val _lastScanned = MutableStateFlow<String?>(null)
    val lastScanned: StateFlow<String?> = _lastScanned

    fun onQrScanned(value: String) {
        _lastScanned.value = value              // ✅ Met à jour la valeur scannée
    }

    fun clearScan() {
        _lastScanned.value = null               // ✅ Réinitialise l’état
    }
}
