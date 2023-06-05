package com.example.fetch_apprenticeship.data.repository

import com.example.fetch_apprenticeship.domain.model.ListItem
import com.example.fetch_apprenticeship.util.Result
import kotlinx.coroutines.flow.Flow

interface ListItemRepository {
    suspend fun getItems(): Flow<Result<List<ListItem>>>
}