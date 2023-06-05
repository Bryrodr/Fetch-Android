package com.example.fetch_apprenticeship.domain.model

/**
 * Domain model for [ListItem]
 * used to map the data from the database to the domain model
 * */
data class ListItem(
    val id: Int,
    val listId: Int,
    val name: String?,
)
