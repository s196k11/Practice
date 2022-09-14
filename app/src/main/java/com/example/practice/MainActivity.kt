package com.example.practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.example.practice.RoomDatabase.Word
import com.example.practice.RoomDatabase.WordApplication
import com.example.practice.RoomDatabase.WordViewModel
import com.example.practice.RoomDatabase.WordViewModelFactory
import com.example.practice.RoomDatabase.screens.DisplayCard
import com.example.practice.RoomDatabase.screens.MainScreen

import com.example.practice.ui.theme.PracticeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                val wordViewModel: WordViewModel by viewModels {
                    WordViewModelFactory((application as WordApplication).repository)
                }


                MainScreen(viewModel = wordViewModel)

            }
        }
    }
}
