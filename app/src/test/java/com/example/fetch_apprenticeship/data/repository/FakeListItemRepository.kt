package com.example.fetch_apprenticeship.data.repository

import com.example.fetch_apprenticeship.data.repository.ListItemRepository
import com.example.fetch_apprenticeship.domain.model.ListItem
import com.example.fetch_apprenticeship.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FakeListItemRepository : ListItemRepository {
    override suspend fun getItems(): Flow<Result<List<ListItem>>> = flow {
        //generate fake data
        val item1 = ListItem(1, 1, "Item 1")
        val item2 = ListItem(2, 2, "Item 2")
        val item3 = ListItem(3, 3, "Item 3")
        val itemList = listOf(item1, item2, item3)
        emit(Result.Success(itemList))
    }
}