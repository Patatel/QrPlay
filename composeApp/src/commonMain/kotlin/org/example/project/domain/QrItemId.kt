package org.example.project.domain

import kotlinx.serialization.Serializable

/**
 * Identifiant fort pour un QrItem.
 * On évite "juste un String" pour ne pas confondre avec d'autres IDs
 * (meilleure sécurité de type dans tout le code).
 */
@Serializable                              // ✅ sérialisable (JSON, disque, réseau)
@JvmInline                                 // ✅ value class => pas de surcoût runtime (wrapper supprimé)
value class QrItemId(val value: String) {
    override fun toString(): String = value // ✅ utile pour logs / debug
}
