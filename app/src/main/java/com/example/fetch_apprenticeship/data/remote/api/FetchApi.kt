package com.example.fetch_apprenticeship.data.remote.api

import com.example.fetch_apprenticeship.data.model.ListItem
import retrofit2.http.GET

interface FetchApi {
    @GET("hiring.json")
    suspend fun getItems(): List<ListItem>
}