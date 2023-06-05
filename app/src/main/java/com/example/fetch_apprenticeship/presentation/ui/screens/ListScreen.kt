package com.example.fetch_apprenticeship.presentation.ui.composable

import HorizontalListItem
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fetch_apprenticeship.presentation.ListViewModel


@Composable
fun ListScreen(
    viewModel: ListViewModel = hiltViewModel()
){
    val configuration = LocalConfiguration.current
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize() ){
        LazyColumn(modifier = Modifier.fillMaxSize()){

            items(state.listItems){ listItem ->
                when(configuration.orientation) {
                    Configuration.ORIENTATION_PORTRAIT -> VerticalListItem(listItem = listItem)
                    Configuration.ORIENTATION_LANDSCAPE -> HorizontalListItem(listItem = listItem)
                }
            }
        }
        if(state.error.isNotBlank()){
            Snackbar(
                modifier = Modifier.align(Alignment.BottomCenter),
            ) {
                Text(text = state.error)
            }
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}