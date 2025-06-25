package com.example.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.demo.database.PeopleDao
import com.example.demo.database.PersonEntity
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinx.coroutines.launch

@Composable
@Preview
fun App(peopleDao: PeopleDao) {
    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//
//            Box(modifier = Modifier.padding(10.dp).border(2.dp, color = Color.Transparent).clip(RoundedCornerShape(20.dp)).background(color = Color.Magenta).padding(10.dp,
//                )) {
//
//                Text("Box", color = Color.White)
//
//            }
//
//            var text by remember { mutableStateOf(("")) }
//            TextField(value = text, onValueChange = {
//                text= it
//            }, placeholder = {
//                Text("Enter name", color = Color.Black)
//            })
//
//
//
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }



        val people by peopleDao.getAllPeople().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()


        LaunchedEffect(true){
            val peopleList = listOf(PersonEntity(name = "Phong"), PersonEntity(name = "John"), PersonEntity(name = "Alice"))

            peopleList.forEach {
                peopleDao.upsert(it)
            }


        }


        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {

            items(people){ person ->

                Text(text = person.name, modifier = Modifier.fillMaxWidth()
                    .clickable{
                        scope.launch {

                            peopleDao.delete(person)

                        }
                    }
                    .padding(16.dp))
            }
        }





    }
}