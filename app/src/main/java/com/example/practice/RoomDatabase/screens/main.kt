package com.example.practice.RoomDatabase.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.example.practice.RoomDatabase.Word
import com.example.practice.RoomDatabase.WordViewModel



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(viewModel: WordViewModel) {

    val list = viewModel.allWords.observeAsState().value


    val word = rememberSaveable {
        mutableStateOf("")
    }



    Column() {
        Box(modifier = Modifier
            .fillMaxHeight(0.3f)
            .fillMaxWidth()
            .shadow(elevation = 4.dp)
            ) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                OutlinedTextField(value = word.value, onValueChange = { word.value = it },
                    label = { Text(text = "Word") },
                    placeholder = { Text(text = "Word") }
                )
                Spacer(modifier = Modifier.height(15.dp))
                Button(onClick = {
                    if (word.value.isNotEmpty()){
                        viewModel.insert(Word(word = word.value))
                        word.value = ""
                    }
                }) {
                    Text(text = "ADD")
                }

            }
            IconButton(onClick = { viewModel.deleteAll() }, modifier = Modifier.align(Alignment.BottomEnd)) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }



        if (list != null) {
            LazyColumn {
                items(items = list) { word ->
                    DisplayCard(t = word.word, onRemoveNote = {viewModel.delete(word)})
                }
            }
        }
    }
}


@Composable
fun DisplayCard(t: String,onRemoveNote: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(4.dp)
        .shadow(elevation = 2.dp, shape = RoundedCornerShape(6.dp))
        .clickable { onRemoveNote() }
    ) {

        Text(text = t, fontSize = 27.sp,modifier = Modifier.align(Alignment.Center))
    }
}