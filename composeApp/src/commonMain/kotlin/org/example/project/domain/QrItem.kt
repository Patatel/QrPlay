package org.example.project.domain

import kotlinx.serialization.Serializable
import kotlinx.datetime.Instant
import kotlin.time.ExperimentalTime

/**
 * Représente une "entrée" de l’historique QR.
 * - Immutable : toutes les propriétés sont val (plus sûr pour l'UI et la concurrence).
 * - Serializable : prêt pour JSON/SQLDelight/adapters.
 */
@Serializable
data class QrItem @OptIn(ExperimentalTime::class) constructor(
    val id: QrItemId,          // ✅ identifiant typé
    val text: String,          // ✅ contenu décodé (URL, texte, etc.)
    val source: QrSource,      // ✅ provenance (caméra, import, manuel…)
    val createdAt: Instant,    // ✅ date de création (UTC, multiplateforme)
    val favorite: Boolean = false, // ✅ flag de mise en favori
    val label: String? = null       // ✅ étiquette libre (optionnelle)
)
