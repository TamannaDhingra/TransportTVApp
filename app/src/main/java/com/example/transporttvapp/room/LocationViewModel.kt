package com.example.transporttvapp.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * The ViewModel role is to provide data to the UI and survive configuration changes.
 * A ViewModel acts as a communication center between the Repository and the UI
 */

class LocationViewModel(application: Application):AndroidViewModel(application) {

    private val readAllLoc:LiveData<List<Location>>
    private val repository:LocationRepository

    init {
        val locationDao=LocationDatabase.getDatabase(application).locationDao()
        repository= LocationRepository(locationDao)
        readAllLoc=repository.readAllLoc
    }

    fun addLoc(location: Location){
        viewModelScope.launch(Dispatchers.IO){
            repository.addLoc(location)
        }
    }
}