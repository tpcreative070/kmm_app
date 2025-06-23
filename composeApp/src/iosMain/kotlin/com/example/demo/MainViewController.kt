package com.example.demo

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.example.demo.database.getPeopleDatabase

fun MainViewController() = ComposeUIViewController {


    val dao = remember {
        getPeopleDatabase().peopleDao()
    }

    App(dao )


}