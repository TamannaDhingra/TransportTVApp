package com.example.transporttvapp.room

import androidx.lifecycle.LiveData

class LocationRepository(private val locationDao: LocationDao) {

    val readAllLoc:LiveData<List<Location>> = locationDao.readAllLoc()

   suspend fun addLoc(location: Location){
        locationDao.addLocation(location)
    }
}