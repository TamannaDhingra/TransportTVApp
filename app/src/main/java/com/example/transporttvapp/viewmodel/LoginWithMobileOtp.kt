package com.example.transporttvapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transporttvapp.model.ApiResponseModel

import com.example.transporttvapp.repository.Repostries
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//viewmodel ka object hum khud se nhi bnate viewmodel provider ka use krte hai
//yha pea aab humne parametrized view model bnaya hai  toh  jb bhi hum parametrized view model bnate hai
//toh uske liye ek factory bhi define krni pdti hai viewmodel factory

                        //view model ko repository ka access chahiye aab
class LoginWithMobileOtp(val repo:Repostries): ViewModel(){
    fun sendOtp( number:String){
        //jaise hi vimemodel call hoga yeh repository ko call krega ki jao data lea aao
        CoroutineScope(Dispatchers.IO).launch {
            repo.getdata(number)//for response
        }
    }

}