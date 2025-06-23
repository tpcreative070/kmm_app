package com.example.demo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.demo.database.PeopleDao
import com.example.demo.database.Person
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import demo.composeapp.generated.resources.Res
import demo.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.flow.compose
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
            val peopleList = listOf(Person(name = "Phong"), Person(name = "John"), Person(name = "Alice"))

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