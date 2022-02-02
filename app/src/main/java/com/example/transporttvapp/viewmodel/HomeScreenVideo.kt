package com.example.transporttvapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transporttvapp.model.ApiResponseModel
import com.example.transporttvapp.model.GetVideo
import com.example.transporttvapp.retroApi.NetworkAdapter
import retrofit2.Call
import retrofit2.Response


class HomeScreenVideo() : ViewModel(){
  private  val datavideo1= MutableLiveData<ApiResponseModel<GetVideo?>>()
      val datatemp: LiveData<ApiResponseModel<GetVideo?>>
        get() = datavideo1



     fun homeScreenVideo()
     {

         NetworkAdapter.getRetrofitInstanceUserData()?.getVideo()?.enqueue(object : retrofit2.Callback<ApiResponseModel<GetVideo?>> {
             override fun onResponse(
                 call: Call<ApiResponseModel<GetVideo?>>,
                 response: Response<ApiResponseModel<GetVideo?>>
             ) {


             }


             override fun onFailure(
                 call: Call<ApiResponseModel<GetVideo?>>,
                 t: Throwable
             ) {
                 Log.d("TAG", "onFailure: Failure DhabaDetail")

             }
         })

     }

    }


