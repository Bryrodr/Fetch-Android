package com.example.fetch_apprenticeship.presentation.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import com.example.fetch_apprenticeship.presentation.ui.composable.ListScreen
import com.example.fetch_apprenticeship.presentation.ui.theme.FetchApprenticeshipTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchApprenticeshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ListScreen()
                }
            }
        }
    }
}





