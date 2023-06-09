package com.example.fetch_apprenticeship.domain.use_case

import com.example.fetch_apprenticeship.data.repository.ListItemRepository
import com.example.fetch_apprenticeship.domain.model.ListItem
import com.example.fetch_apprenticeship.util.Result
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

/**
 * Use case for [GetListItems]
 * used to fetch the list items from the database
 */
class GetListItems @Inject constructor(
    private val repository: ListItemRepository
) {
     suspend fun invoke(): Flow<Result<List<ListItem>>> {
        return repository.getItems()
    }
}