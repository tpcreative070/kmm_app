package com.example.demo.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface PeopleDao {
    @Upsert
    suspend fun upsert(person: PersonEntity)

    @Delete
    suspend fun  delete(person: PersonEntity)

    @Query("SELECT * FROM persons")
    fun getAllPeople(): Flow<List<PersonEntity>>

}