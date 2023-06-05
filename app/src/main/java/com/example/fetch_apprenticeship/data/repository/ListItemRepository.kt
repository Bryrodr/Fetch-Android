package com.example.fetch_apprenticeship.data.repository

import com.example.fetch_apprenticeship.domain.model.ListItem
import com.example.fetch_apprenticeship.util.Result
import kotlinx.coroutines.flow.Flow


/**
 * Interface for [ListItemRepositoryImpl]
 * used to fetch the list items from the api and store them in the local database
 */
interface ListItemRepository {
    suspend fun getItems(): Flow<Result<List<ListItem>>>
}