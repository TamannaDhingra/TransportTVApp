package com.example.transporttvapp.builderobjects

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroBuilder {
    fun UserData(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://staging.transportmall.com:8080/api/v1/")

            .build()
    }



        fun AllDhabaDetails(): Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://adminuat.transportmall.com/api/v1/")

                .build()
        }

    fun baseUrlForVideo():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://player.vimeo.com/video/")

            .build()
    }


}