package com.example.fetch_apprenticeship.data.remote.api

import com.example.fetch_apprenticeship.data.local.entity.ListItemEntity
import retrofit2.http.GET

interface FetchApi {
    @GET("hiring.json")
    suspend fun getItems(): List<ListItemEntity>

    companion object{
        const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
    }
}