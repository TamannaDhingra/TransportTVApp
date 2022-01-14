package com.example.transporttvapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.transporttvapp.repository.Repostries
import com.example.transporttvapp.ui.HomeScreen


//factory help krti hai viewmodels ko create krne k liye
class LoginWithMobileOtpFactory(val repo:Repostries):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginWithMobileOtp(repo) as T
    }
}

//aab hum aapni main activity mei viewmodels ko access krenge viewmodels ka instance bnakr