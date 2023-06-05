package com.example.fetch_apprenticeship.presentation

import com.example.fetch_apprenticeship.domain.model.ListItem


data class ListState(
    val listItems: List<ListItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
