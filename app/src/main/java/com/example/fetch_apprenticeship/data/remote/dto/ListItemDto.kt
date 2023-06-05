package com.example.fetch_apprenticeship.data.remote.dto

import com.example.fetch_apprenticeship.data.local.entity.ListItemEntity


/**
 * Data transfer object for [ListItemEntity]
 * used to map the data from the API to the database
 * */
data class ListItemDto(
    val id: Int,
    val listId: Int,
    val name: String?,
)

fun ListItemDto.toListItemEntity() = ListItemEntity(
    id = id,
    listId = listId,
    name = name,
)
