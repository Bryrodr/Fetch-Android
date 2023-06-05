package com.example.fetch_apprenticeship.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetch_apprenticeship.domain.use_case.GetListItems
import com.example.fetch_apprenticeship.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(
    private val getListItems: GetListItems
): ViewModel() {
    private val _state = mutableStateOf(ListState())
    val state: State<ListState> = _state

    init {
        viewModelScope.launch {
            getListItems()
        }
    }
    private suspend fun getListItems() {
        getListItems.invoke().onEach { result ->
            when(result){
                //if its success
                is Result.Success -> {
                    _state.value = ListState(listItems = result.data ?: emptyList())
                }
                is Result.Error -> {
                    _state.value = ListState(error = result.message ?: "An unexpected error occurred")
                }
                is Result.Loading -> {
                    _state.value = ListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
