package com.example.demo

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.demo.database.getPeopleDatabase

fun MainViewController() = ComposeUIViewController {


    val dao = remember {
        getPeopleDatabase().setDriver(BundledSQLiteDriver()).build().peopleDao()
    }

    App(dao )


}