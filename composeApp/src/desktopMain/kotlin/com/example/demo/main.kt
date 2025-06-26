package com.example.demo

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.demo.database.getDatabaseBuilder
import kotlinx.coroutines.Dispatchers

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "demo",
    ) {

        val dao = getDatabaseBuilder().setDriver(BundledSQLiteDriver()).setQueryCoroutineContext(Dispatchers.IO).build().peopleDao()
        App(dao)
    }
}