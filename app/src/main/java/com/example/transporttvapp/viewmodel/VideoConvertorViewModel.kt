package com.example.transporttvapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transporttvapp.model.ApiResponseModel
import com.example.transporttvapp.model.DhabaLocationResponse
import com.example.transporttvapp.model.GetVideo
import com.example.transporttvapp.retroApi.NetworkAdapter
import com.google.gson.JsonArray

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import java.lang.reflect.Array.get


class VideoConvertorViewModel():ViewModel() {

    val datavideo= MutableLiveData<JsonObject?>()
    val datavideotemp: LiveData<JsonObject?>?
        get() = datavideo




    fun getVideoLink(id: String) {
        NetworkAdapter.getRetrofitInstanceVideo()?.  getVideoLink(id)
            ?.enqueue(object : retrofit2.Callback<JsonObject?> {
                override fun onResponse(
                    call: Call<JsonObject?>,
                    response: Response<JsonObject?>
                ) {
                    val jsonObject: JsonObject? = response.body()
                    val req = jsonObject!!.getAsJsonObject("request")
                    val file = req.getAsJsonObject("files")
                    val arr = file.getAsJsonArray("progressive")
                    val url = arr[0].asJsonObject["url"].asString

                    // Build the media item. n

                    // Build the media item.
                    //*val mediaItem: MediaItem = MediaItem.fromUri(url)
                    // Set the media item to be played.
                    // Set the media item to be played.
                   // player.setMediaItem(mediaItem)
                    // Prepare the player.
                    // Prepare the player.
                  //  player.prepare()
                    // Start the playback.
                    // Start the playback.
                   // player.play()
                }

                override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                    Log.d("TAG", "onFailure: Failure video extractor")
                }
            })

    }
}