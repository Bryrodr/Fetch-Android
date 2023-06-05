package com.example.fetch_apprenticeship.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list")
data class ListItemEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val listId: Int,
    val name: String?,
)


/*
While not necessary for this project
its good practice to have a mapper function
for example if the api got updated and has 10 more entrys
but we still want to keep the same information
 */
fun ListItemEntity.toListItem() = com.example.fetch_apprenticeship.domain.model.ListItem(
    id = id,
    listId = listId,
    name = name,
)