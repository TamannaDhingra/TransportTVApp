package com.example.transporttvapp.repository

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.transporttvapp.model.*
import com.example.transporttvapp.retroApi.RetroApi
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

 //repositry api se interact kregi
                 //repositry ko api ka instance milega api se interact krne k liye
class Repostries(val retro: RetroApi, val context: Context?) {
    lateinit var getotpformatch: String


    //viewmodel yeh wale function call krega or yeh fun hume api se result lakr dega
    suspend fun getdata(number: String) {

        val ob = UserSendOtp()
        ob.phone = "+91" + number
        ob.phone_suffix = number
        ob.std_code = "+91"
        ob.build_type = "qa"
        ob.version_code = "1018"

        val getresponse = retro.sendOtp(ob)
        Log.d("TAG", "getdata: " + getresponse.body()?.data?.phone)
        Log.d("TAG", "getdata: " + getresponse.body()?.data?.otp)
        getotpformatch = getresponse.body()?.data?.otp.toString()

    }

    suspend fun verifydata(verifyno: String, view: View) {
        val ob1 = UserVerifyOtp()
        ob1.phone = "+917986535827"
        ob1.phone_suffix = "7986535827"
        ob1.device_type = "android"
        ob1.device_notification_token = "android_default"
        ob1.std_code = "+91"
        ob1.build_type = "qa"
        ob1.version_code = "1018"
        ob1.otp = verifyno

        val getresponseotp = retro.verifyUsersData(ob1)
        Log.d("TAG", "verifydata: " + getresponseotp.body()?.data?.otp)

    }


}