package com.example.transporttvapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.FragmentRouteTabBinding
import com.example.transporttvapp.ui.ShowDhabas

class RouteTabFragment : Fragment() {
   lateinit var binding: FragmentRouteTabBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRouteTabBinding.inflate(inflater, container, false)

        binding.showDhabaBtn.setOnClickListener {
           startActivity(Intent(context,ShowDhabas::class.java))
        }




        return binding.root
    }


    }
