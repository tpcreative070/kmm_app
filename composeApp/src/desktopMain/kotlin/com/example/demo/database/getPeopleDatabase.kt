package com.example.demo.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<PeopleDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "/people.db")
    return Room.databaseBuilder<PeopleDatabase>(
        name = dbFile.absolutePath,
    )
}