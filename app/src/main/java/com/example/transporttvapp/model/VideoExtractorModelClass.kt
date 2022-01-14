package com.example.transporttvapp.model

import com.google.android.gms.maps.model.Dash
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.stream.Stream

class VideoExtractorModelClass {
    /*class Available {
        @SerializedName("is_current")
        @Expose
        var isCurrent: Int? = null

        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("file_id")
        @Expose
        var fileId: Long? = null
    }

    class Dash {
        @SerializedName("separate_av")
        @Expose
        var separateAv: Boolean? = null

       *//* @SerializedName("streams")
        @Expose

        var streams: List<Stream>? = null*//*

        @SerializedName("cdns")
        @Expose
        var cdns: Cdns? = null

        @SerializedName("streams_avc")
        @Expose
        var streamsAvc: List<StreamsAvc>? = null

        @SerializedName("default_cdn")
        @Expose
        var defaultCdn: String? = null
    }

    class Files {
        @SerializedName("dash")
        @Expose
        var dash: com.google.android.gms.maps.model.Dash? = null

        @SerializedName("hls")
        @Expose
        var hls: Hls? = null

        @SerializedName("progressive")
        @Expose
        var progressive: List<Progressive>? = null
    }
*/
    }
