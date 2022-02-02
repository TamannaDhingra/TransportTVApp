package com.example.transporttvapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao

interface LocationDao {

    /**
     * ignore to add same user multiple times
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLocation(location: Location)

    @Query("Select * from location_table order by id ASC")
    fun readAllLoc(): LiveData<List<Location>>
}