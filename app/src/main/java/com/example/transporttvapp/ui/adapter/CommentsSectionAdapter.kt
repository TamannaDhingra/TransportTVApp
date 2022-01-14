package com.example.transporttvapp.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.transporttvapp.databinding.CommentsViewBinding
import com.example.transporttvapp.databinding.HomeScreenVideoViewBinding
import com.example.transporttvapp.model.GetVideo

class CommentsSectionAdapter(val context: Context) :
    RecyclerView.Adapter<CommentsSectionAdapter.ViewHolderClass>() {

    class ViewHolderClass(val binding: CommentsViewBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}