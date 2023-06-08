package com.example.fetch_apprenticeship.data.remote.api

import com.example.fetch_apprenticeship.data.remote.dto.ListItemDto
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit API interface for the Fetch API
 * */
interface FetchApi {
    @GET("hiring.json")
    suspend fun getRemoteItems(): Response<List<ListItemDto>>
}