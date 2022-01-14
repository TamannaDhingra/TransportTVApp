package com.example.transporttvapp.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.transporttvapp.databinding.InflaterDhabaImagesBinding
import com.example.transporttvapp.databinding.ShowDhabaListviewBinding
import com.example.transporttvapp.model.DhabaLocationResponse

class DhabaDetailsAdapter(val context: Context):
    RecyclerView.Adapter<DhabaDetailsAdapter.ViewHolderClass>() {
    class ViewHolderClass(val binding:InflaterDhabaImagesBinding):RecyclerView.ViewHolder(binding.root)

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