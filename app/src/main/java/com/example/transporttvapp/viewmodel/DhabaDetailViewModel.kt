package com.example.transporttvapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transporttvapp.model.ApiResponseModel
import com.example.transporttvapp.model.DhabaDetailModel

import com.example.transporttvapp.retroApi.NetworkAdapter
import retrofit2.Call
import retrofit2.Response

class DhabaDetailViewModel():ViewModel() {

    private  val dhabadata1= MutableLiveData<ApiResponseModel<DhabaDetailModel>>()
    val dhabadata: LiveData<ApiResponseModel<DhabaDetailModel>>
        get() = dhabadata1



    fun getDhabaDetail()
    {

        NetworkAdapter.getRetrofitInstanceAll()?.getDetailofDhaba().enqueue(object :retrofit2.Callback<ApiResponseModel<DhabaDetailModel>>{
            override fun onResponse(
                call: Call<ApiResponseModel<DhabaDetailModel>>,
                response: Response<ApiResponseModel<DhabaDetailModel>>
            ) {
                dhabadata1.postValue(response.body())
            }

            override fun onFailure(call: Call<ApiResponseModel<DhabaDetailModel>>, t: Throwable) {
                Log.d("TAG", "onFailure: Failure DhabaDetailViewModel")
            }
        })

    }

}