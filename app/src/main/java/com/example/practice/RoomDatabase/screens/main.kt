package com.example.practice.RoomDatabase.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.example.practice.RoomDatabase.WordViewModel



@Composable
fun MainScreen(onClick:() -> Unit,viewModel: WordViewModel) {
    val context = LocalContext.current

    val word = rememberSaveable {
        mutableStateOf("")
    }


    Column() {
        Box(modifier = Modifier
            .fillMaxHeight(0.2f)
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
                Button(onClick = { }) {
                    Text(text = "ADD")
                }
            }
        }


        val l = listOf<Int>(1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            0,
            9,
            8,
            7,
            6,
            5,
            4,
            3,
            22,
            1)

        LazyColumn() {
            items(l) { item ->
                DisplayCard(t = item.toString())
            }
        }
    }
}


@Composable
fun DisplayCard(t: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(4.dp)
        .shadow(elevation = 2.dp, shape = RoundedCornerShape(6.dp))) {

        Text(text = t, fontSize = 27.sp,modifier = Modifier.align(Alignment.Center))
    }
}