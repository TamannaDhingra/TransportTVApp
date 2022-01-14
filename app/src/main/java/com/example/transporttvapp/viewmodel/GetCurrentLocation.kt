package com.example.transporttvapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transporttvapp.model.ApiResponseModel
import com.example.transporttvapp.model.DhabaLocationResponse

import com.example.transporttvapp.repository.Repostries
import com.example.transporttvapp.retroApi.NetworkAdapter
import com.example.transporttvapp.retroApi.RetroApi
import retrofit2.Call
import retrofit2.Response

class GetCurrentLocation():ViewModel() {
    val data1= MutableLiveData<ApiResponseModel<List<DhabaLocationResponse>?>>()
    val datatemp: LiveData<ApiResponseModel<List<DhabaLocationResponse>?>>
        get() = data1


    fun getLocation(lat:String,lang:String)
    {

        NetworkAdapter.getRetrofitInstanceAll().getDhabasByLocation(lat,lang).enqueue(object : retrofit2.Callback<ApiResponseModel<List<DhabaLocationResponse>?>> {
            override fun onResponse(
                call: Call<ApiResponseModel<List<DhabaLocationResponse>?>>,
                response: Response<ApiResponseModel<List<DhabaLocationResponse>?>>
            ) {
                Log.d("TAG", "onResponse: Success DhabaDetail")

                data1.postValue(response.body())
                Log.d("TAG", "onResponse: Success DhabaDetail"+response.body()?.data?.get(0)?.dhaba?.name)


            }

            override fun onFailure(
                call: Call<ApiResponseModel<List<DhabaLocationResponse>?>>,
                t: Throwable
            ) {
                Log.d("TAG", "onFailure: Failure DhabaDetail")

            }
        })

    }

}