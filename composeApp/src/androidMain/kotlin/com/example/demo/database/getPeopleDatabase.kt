package com.example.demo.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getPeopleDatabase(context: Context) : PeopleDatabase {
    val dbFile = context.getDatabasePath("people.db")
    return Room.databaseBuilder<PeopleDatabase>(context = context.applicationContext, name = dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .build()
}