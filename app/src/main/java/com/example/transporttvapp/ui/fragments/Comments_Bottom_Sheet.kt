package com.example.transporttvapp.ui.fragments

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.FragmentCommentsBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Comments_Bottom_Sheet( context: Context) : BottomSheetDialog(context) {
    lateinit var binding:FragmentCommentsBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val contextt=this
        binding= FragmentCommentsBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)
            binding.crossbtn.setOnClickListener {
                contextt.dismiss()
            }



    }
}