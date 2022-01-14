package com.example.transporttvapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DhabaDetailViewModelFactory():ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DhabaDetailViewModel() as T
    }
}