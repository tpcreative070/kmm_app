package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demo.database.getPeopleDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val dao = getPeopleDatabase(applicationContext).peopleDao()
        setContent {
            App(dao)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    //App()
}