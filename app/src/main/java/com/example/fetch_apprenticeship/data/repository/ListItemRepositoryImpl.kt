package com.example.fetch_apprenticeship.data.repository

import com.example.fetch_apprenticeship.data.local.dao.ListDao
import com.example.fetch_apprenticeship.data.local.entity.toListItem
import com.example.fetch_apprenticeship.data.remote.api.FetchApi
import com.example.fetch_apprenticeship.data.remote.dto.toListItemEntity
import com.example.fetch_apprenticeship.domain.model.ListItem
import com.example.fetch_apprenticeship.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


/**
 * Repository for [ListItemRepository]
 * used to fetch the list items from the api and store them in the local database
 */
class ListItemRepositoryImpl @Inject constructor(
    private val listApi: FetchApi,
    private val dao: ListDao
): ListItemRepository {
    override suspend fun getItems(): Flow<Result<List<ListItem>>> = flow {
        emit(Result.Loading())
        val listItems = dao.getListItems().map { it.toListItem()}
        emit(Result.Loading(data = listItems))

        try{
            val remoteListItems = listApi.getItems().map { it.toListItemEntity()}
            dao.insertAllItems(remoteListItems)
        } catch(e: HttpException){
            emit(Result.Error("An unexpected error occurred", data = listItems))

        } catch (e: IOException){
            emit(Result.Error("Check your internet connection.", data = listItems))
        }

        val localListItems = dao.getListItems().map { it.toListItem() }
        emit(Result.Success(localListItems))
    }

}