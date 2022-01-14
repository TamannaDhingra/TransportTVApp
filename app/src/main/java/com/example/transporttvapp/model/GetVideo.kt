package com.example.transporttvapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class GetVideo :Serializable{
    var data: List<VideoData>? = null

        class VideoData  :Serializable{
            @SerializedName("_id")
            @Expose
            val id: String? = null

            @SerializedName("status")
            @Expose
            val status: Boolean? = null

            @SerializedName("is_deleted")
            @Expose
            val isDeleted: Boolean? = null

            @SerializedName("name")
            @Expose
             val name: String? = null

            /*@SerializedName("name_lang")
            @Expose
            private val nameLang: NameLang? = null*/

            @SerializedName("category_type")
            @Expose
           val categoryType: String? = null

            @SerializedName("description")
            @Expose
           val description: String? = null

            @SerializedName("addedBy")
            @Expose
            val addedBy: String? = null

            @SerializedName("slug")
            @Expose
           val slug: String? = null

            @SerializedName("createdAt")
            @Expose
            val createdAt: String? = null

            @SerializedName("updatedAt")
            @Expose
            val updatedAt: String? = null

            @SerializedName("sortingNumber")
            @Expose
           val sortingNumber: Int? = null

            @SerializedName("__v")
            @Expose
            val v: Int? = null

            @SerializedName("isCategory")
            @Expose
             val isCategory: Boolean? = null

            @SerializedName("vimeoLink")
            @Expose
            val vimeoLink: String? = null


            @SerializedName("image")
            @Expose
            val image: String? = null


            @SerializedName("public_thumbnail_image")
            @Expose
            val public_thumbnail_image: String? = null


            @SerializedName("title")
            @Expose
            val title: String? = null

        }

}