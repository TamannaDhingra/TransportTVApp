package com.example.transporttvapp.retroApi

import com.example.transporttvapp.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import com.google.gson.JsonObject

import retrofit2.http.GET




interface RetroApi {


    @POST("user/sendOtp")
    suspend fun sendOtp(@Body sendotp:UserSendOtp):Response <GetResponseSendOtp>

    @POST("user/verifyOtp")
    suspend fun verifyUsersData(@Body verifyotp: UserVerifyOtp) :Response<GetResponseVerifyOtp>

    @GET("common/getVideoByCategory?categorySlug=latest-news&userId=61a859a42f5af50012f5db3b&page=1&limit=15")
     fun getVideo():Call<ApiResponseModel<GetVideo?>>

    @FormUrlEncoded
    @POST("dhaba/getlocation")
    fun getDhabasByLocation(@Field("latitude") latitude: String?, @Field("longitude") longitude: String?): Call<ApiResponseModel<List<DhabaLocationResponse>?>>


    @GET("dhaba/getDhabaByID?id=616a813b79e1530012f94f29}")
    fun getDetailofDhaba() :Call<ApiResponseModel<DhabaDetailModel>>

    @GET("{id}/{config}")
    fun getVideoLink(@Path("id") id: String?): Call<JsonObject?>?

    /*@GET("{video_id}/config")
    fun getVimeoUrlResponse(@Path("video_id") id: String?): Call<VimeoResponse?>?*/


}

