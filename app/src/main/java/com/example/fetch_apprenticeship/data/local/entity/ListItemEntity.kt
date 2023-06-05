package com.example.fetch_apprenticeship.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity for [ListItemEntity]
 * used to map the data from the database to the domain model
 * */
@Entity(tableName = "list")
data class ListItemEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val listId: Int,
    val name: String?,
)



fun ListItemEntity.toListItem() = com.example.fetch_apprenticeship.domain.model.ListItem(
    id = id,
    listId = listId,
    name = name,
)