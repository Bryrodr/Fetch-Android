package com.example.fetch_apprenticeship.data.repository

import android.util.Log
import com.example.fetch_apprenticeship.data.local.dao.ListDao
import com.example.fetch_apprenticeship.data.local.entity.toListItem
import com.example.fetch_apprenticeship.data.remote.api.FetchApi
import com.example.fetch_apprenticeship.domain.model.ListItem
import com.example.fetch_apprenticeship.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ListItemRepositoryImpl @Inject constructor(
    private val listApi: FetchApi,
    private val dao: ListDao
): ListItemRepository {
    override suspend fun getItems(): Flow<Result<List<ListItem>>> = flow {

        emit(Result.Loading())
        val listItems = dao.getListItems().map { it.toListItem()}
        //emites data as its loading
        emit(Result.Loading(data = listItems))

        try{
            val remoteListItems = listApi.getItems()
            dao.insertAllItems(remoteListItems)
        } catch(e: HttpException){
            emit(Result.Error("An unexpected error occurred", data = listItems))

        } catch (e: IOException){
            emit(Result.Error("Check your internet connection.", data = listItems))
        }

        //in the case of live data would get most up to date information
        val localListItems = dao.getListItems().map { it.toListItem() }
        emit(Result.Success(localListItems))
    }

}