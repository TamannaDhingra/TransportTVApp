package com.example.transporttvapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivityChooseLanguageBinding
import com.example.transporttvapp.databinding.ActivityMainBinding
import com.example.transporttvapp.viewmodel.HomeScreenVideo
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navigation:NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)




    }
}