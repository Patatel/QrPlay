package org.example.project.domain

import kotlinx.serialization.Serializable

/**
 * D'où vient le contenu du QR ?
 * - SCANNER : pris via la caméra (Android) ou image décodée (Desktop)
 * - IMAGE_IMPORT : import d'un fichier image local (galerie/FS)
 * - MANUAL : saisi par l'utilisateur (ex: coller un lien)
 * - SHARED : reçu via partage (intent Android ou futur partage Desktop)
 */
@Serializable
enum class QrSource {
    SCANNER,
    IMAGE_IMPORT,
    MANUAL,
    SHARED
}
