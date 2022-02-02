package com.example.transporttvapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.transporttvapp.databinding.ShowDhabaListviewBinding
import com.example.transporttvapp.model.Dhaba
import com.example.transporttvapp.model.DhabaLocationResponse

import android.R
import android.content.Intent
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target


import com.bumptech.glide.request.RequestOptions
import com.example.transporttvapp.ui.DhabaDetails
import com.example.transporttvapp.ui.MapsActivity
import com.example.transporttvapp.ui.ShowRouteActivity


class ShowDhabasAdapter(val context: Context, val list: List<DhabaLocationResponse>):RecyclerView.Adapter<ShowDhabasAdapter.ViewHolderClass>() {


    class ViewHolderClass(val binding: ShowDhabaListviewBinding):RecyclerView.ViewHolder(binding.root){
        var list= mutableListOf<String>()
      fun dhabadetail(data:Dhaba,context: Context){
          binding.dhabaDetails=data

          binding.dhabaDetailImage.setOnClickListener {
              /*val intent = Intent(context, DhabaDetails::class.java)
              intent.putExtra("idData",data._id)
              context.startActivity(intent)*/
          }
         /* binding.imageView7.setOnClickListener {
              val intent=Intent(context,MapsActivity::class.java)
              context.startActivity(intent)
          }*/

}


}

       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

           val binding=ShowDhabaListviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderClass(binding)


       }

override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
// holder.binding.nametext=this.list[position]
holder.dhabadetail(list.get(position).dhaba,context)



}




override fun getItemCount(): Int {
return list.size
}

}