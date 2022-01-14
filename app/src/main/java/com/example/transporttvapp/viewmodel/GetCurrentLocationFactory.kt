package com.example.transporttvapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.transporttvapp.repository.Repostries


class GetCurrentLocationFactory(val repo: Repostries): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GetCurrentLocation() as T
    }
}
