package com.example.demo.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(entities = [PersonEntity::class], version = 1, exportSchema = false)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class PeopleDatabase : RoomDatabase() {

    abstract fun peopleDao(): PeopleDao
}


// Room compiler generates the `actual` implementations


expect object AppDatabaseConstructor : RoomDatabaseConstructor<PeopleDatabase> {
    override fun initialize(): PeopleDatabase
}