package com.example.transporttvapp.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.transporttvapp.viewmodel.LoginWithMobileOtpFactory
import com.example.transporttvapp.viewmodel.LoginWithMobileOtp
import com.example.transporttvapp.builderobjects.RetroBuilder

import com.example.transporttvapp.databinding.ActivityLoginWithMobileNumBinding
import com.example.transporttvapp.repository.Repostries
import com.example.transporttvapp.retroApi.RetroApi

class LoginWithMobileNum : AppCompatActivity() {
  lateinit var binding: ActivityLoginWithMobileNumBinding
  lateinit var mobileno:String
   lateinit var viewmodelvar:LoginWithMobileOtp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginWithMobileNumBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val retrobuilder=RetroBuilder.UserData().create(RetroApi::class.java)
        val repositry=Repostries(retrobuilder,this)
        viewmodelvar=ViewModelProvider(this,LoginWithMobileOtpFactory(repositry)).get(LoginWithMobileOtp::class.java)

        //go to verify OTP Activity
        binding.continuebtn.setOnClickListener {
            val getnum=binding.mobileNumText.text
            viewmodelvar.sendOtp(getnum.toString())

            if (binding.continuebtn.isEnabled==true) {
                val intent = Intent(this, VerifyMobileNum::class.java)
                startActivity(intent)
            }

        }


        //to change the colour of Continue Button
        binding.mobileNumText.doOnTextChanged { text, start, before, count ->

            if(text?.length==10)
            {
                binding.continuebtn.setBackgroundColor(Color.RED)
                mobileno=text.toString()
                binding.continuebtn.isEnabled=true

            }
            else{
                binding.continuebtn.setBackgroundColor(Color.GRAY)
            }
        }
    }
}