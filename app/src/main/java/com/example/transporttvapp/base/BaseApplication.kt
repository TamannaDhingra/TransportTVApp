package com.example.transporttvapp.base

import android.app.Application
import android.content.Context
import com.example.transporttvapp.builderobjects.RetroBuilder

import com.example.transporttvapp.repository.Repostries
import com.example.transporttvapp.retroApi.RetroApi

class BaseApplication : Application(){

      lateinit var basecontext:Context
      lateinit var repository: Repostries
        override fun onCreate() {
            super.onCreate()
             basecontext=this
            //database= PostDatabaseBuilder.getInstanse(applicationContext)
           // val retro= RetroBuilder.sendOTP().create(RetroApi::class.java)
            //val database=UserDatabase.getInstanse(this)

           // repository=Repostries(retro,applicationContext)



        }
    fun returnvariable():Context{
        return basecontext
    }
    }
