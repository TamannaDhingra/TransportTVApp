package com.example.transporttvapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingAdapter {
         @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, imageUrl: String?) {
            Glide.with(view.getContext())
                .load(imageUrl).apply(RequestOptions())
                .into(view)
        }

    @JvmStatic
    @BindingAdapter("loadimage")
    fun shoeImageforVideo(view: ImageView, imageUrl: String?) {
        Glide.with(view.getContext())
            .load(imageUrl).apply(RequestOptions())
            .into(view)
    }


    }
