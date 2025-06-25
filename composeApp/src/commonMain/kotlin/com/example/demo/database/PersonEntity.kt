package com.example.demo.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class PersonEntity(val name: String, @PrimaryKey(autoGenerate = true)val id: Int = 0)
