package com.example.transporttvapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class Location (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val search_loc:String
        )
