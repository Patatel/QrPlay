package org.example.project.domain

import kotlinx.coroutines.flow.Flow

interface QrRepository {
    val items: Flow<List<QrItem>>

    suspend fun insert(item: QrItem)

    suspend fun delete(id: QrItemId)

    suspend fun clear()
}
