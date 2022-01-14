package com.example.transporttvapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivityDhabaDetailsBinding
import com.example.transporttvapp.model.GetVideo
import com.example.transporttvapp.viewmodel.DhabaDetailViewModel
import com.example.transporttvapp.viewmodel.DhabaDetailViewModelFactory

class DhabaDetails : AppCompatActivity() {

    lateinit var binding:ActivityDhabaDetailsBinding
    lateinit var getDhabaid:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_dhaba_details)

        val intent = getIntent()
        getDhabaid = intent.getStringExtra("idData").toString()


        val viewmodel=ViewModelProvider(this,DhabaDetailViewModelFactory()).get(DhabaDetailViewModel::class.java)
        viewmodel.getDhabaDetail()

    /* viewmodel.dhabadata.observe(this , Observer{
            Log.d("TAG", it.data?.Data()?.Dhaba()?.name.toString())
        })*/

    }
}