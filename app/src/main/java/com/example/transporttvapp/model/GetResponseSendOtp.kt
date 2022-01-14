package com.example.transporttvapp.model

import android.provider.ContactsContract

class GetResponseSendOtp {
    lateinit var data:Data
  class  Data{
      lateinit var otp:String
      lateinit var phone:String
      lateinit var phone_suffix:String
      lateinit var std_code:String


    }
}