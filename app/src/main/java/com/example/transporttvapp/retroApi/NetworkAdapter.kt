package com.example.transporttvapp.retroApi

import com.example.transporttvapp.builderobjects.RetroBuilder

object NetworkAdapter {

    fun getRetrofitInstanceUserData(): RetroApi? {
        return RetroBuilder.UserData().create(RetroApi::class.java)
    }
    fun getRetrofitInstanceAll(): RetroApi {
        return RetroBuilder.AllDhabaDetails().create(RetroApi::class.java)
    }

    fun getRetrofitInstanceVideo(): RetroApi {
        return RetroBuilder.baseUrlForVideo().create(RetroApi::class.java)
    }
}