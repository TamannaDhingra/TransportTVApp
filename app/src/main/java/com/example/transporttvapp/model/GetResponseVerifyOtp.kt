package com.example.transporttvapp.model

class GetResponseVerifyOtp {
    lateinit var data:Data
    class  Data {
        lateinit var otp: String
        lateinit var phone: String
        lateinit var phone_suffix: String
    }
}