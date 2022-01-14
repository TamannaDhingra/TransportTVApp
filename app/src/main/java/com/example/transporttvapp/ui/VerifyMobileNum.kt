package com.example.transporttvapp.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.transporttvapp.R
import com.example.transporttvapp.viewmodel.LoginWithMobileOtpFactory
import com.example.transporttvapp.viewmodel.LoginWithMobileOtp
import com.example.transporttvapp.builderobjects.RetroBuilder
import com.example.transporttvapp.databinding.ActivityVerifyMobileNumBinding
import com.example.transporttvapp.repository.Repostries
import com.example.transporttvapp.retroApi.RetroApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class VerifyMobileNum : AppCompatActivity() {
    lateinit var binding: ActivityVerifyMobileNumBinding
    lateinit var viewmodelvar: LoginWithMobileOtp

    lateinit var repositry: Repostries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verify_mobile_num)

        //aab repository ko retrofit ka refrence chahiye toh hume retrobuider bhi create krna pdega
        val retrobuilder = RetroBuilder.UserData().create(RetroApi::class.java)
        
        //viewmodel mei repository pass krni hai toh repository ka refrence create krna pdega
        repositry = Repostries(retrobuilder, this)

        //isme factory define krni hai ki kis factory k throgh aap is object ko create krna chahte hai
        //owner pass hoga ki kis class mei use krna hai is viewmodel ko
        viewmodelvar = ViewModelProvider(this, LoginWithMobileOtpFactory(repositry))
            .get(LoginWithMobileOtp::class.java)


        binding.verifyContBtn.setOnClickListener {
            val getverifyotp = binding.firstPinView.text
            CoroutineScope(Dispatchers.IO).launch {
                repositry.verifydata(getverifyotp.toString(), binding.verifyContBtn)

            }
            if (binding.verifyContBtn.isEnabled==true) {
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
            }

        }


        //to change the colour of Continue Button
        binding.firstPinView.doOnTextChanged { text, start, before, count ->

            if (text?.length == 4) {
                binding.verifyContBtn.setBackgroundColor(Color.RED)
                binding.verifyContBtn.isEnabled=true


            } else {
                binding.verifyContBtn.setBackgroundColor(Color.GRAY)

            }


        }


    }
}