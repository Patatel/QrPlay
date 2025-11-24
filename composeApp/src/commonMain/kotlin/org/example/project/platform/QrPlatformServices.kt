// commonMain/org/example/project/platform/QrPlatformServices.kt
package org.example.project.platform

import org.example.project.domain.QrItem

/**
 * Génère une image PNG de QR à partir d'un texte.
 */
interface QrImageGenerator {
    /**
     * @param text  contenu du QR (URL, texte…)
     * @param size  taille en pixels (ex: 512)
     * @return      ByteArray du PNG
     */
    suspend fun generatePng(text: String, size: Int): ByteArray
}

/**
 * Sauvegarde une image (QR) sur le device.
 */
interface MediaSaver {
    /**
     * @param bytes   image PNG
     * @param fileName nom de fichier sans extension
     * @return chemin ou URI logique de sauvegarde
     */
    suspend fun saveImage(bytes: ByteArray, fileName: String): SavedMedia
}

data class SavedMedia(
    val pathOrUri: String
)

/**
 * Partage une image + texte.
 */
interface ShareBridge {
    suspend fun shareQr(item: QrItem, imageBytes: ByteArray?)
}

/**
 * Permet à l'utilisateur de choisir un fichier image.
 */
interface FilePicker {
    suspend fun pickImage(): PickedFile?
}

data class PickedFile(
    val bytes: ByteArray,
    val name: String?
)

/**
 * Décode un QR dans une image.
 */
interface QrImageScanner {
    suspend fun decodeQr(bytes: ByteArray): String?
}
