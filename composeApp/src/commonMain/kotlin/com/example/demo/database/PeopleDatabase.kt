package com.example.demo.database

import androidx.room.Database
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1)

abstract class PeopleDatabase : RoomDatabase() {

    abstract fun peopleDao(): PeopleDao
}
