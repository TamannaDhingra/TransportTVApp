package com.example.transporttvapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VideoConvertorViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VideoConvertorViewModel() as T
    }
}