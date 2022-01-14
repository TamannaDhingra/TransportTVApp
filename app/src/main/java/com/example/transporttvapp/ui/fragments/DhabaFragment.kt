package com.example.transporttvapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.R.attr.data

import android.R
import android.R.attr
import android.app.Activity
import android.content.Context

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.transporttvapp.databinding.ActivityBottomNavBinding.bind
import com.example.transporttvapp.databinding.ActivityBottomNavBinding.inflate
import com.example.transporttvapp.databinding.FragmentDhabaBinding
import com.example.transporttvapp.databinding.FragmentTransportTV3Binding


//import com.example.transporttvapp.builderobjects.sendOTP


class DhabaFragment(val context : Activity) : Fragment() {
    lateinit var binding: FragmentDhabaBinding
    private val LocationTabFragment1 = com.example.transporttvapp.ui.fragments.LocationTabFragment(context,context)
    private val RouteTabFragment1 = com.example.transporttvapp.ui.fragments.RouteTabFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDhabaBinding.inflate(inflater, container, false)

        binding.rbLocation.setOnClickListener {
            replaceFragment(LocationTabFragment1)
        }

        binding.rbRoute.setOnClickListener {
            replaceFragment(RouteTabFragment1)
        }
        replaceFragment(LocationTabFragment1)

        return binding.root
    }

    fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transcation = activity?.supportFragmentManager?.beginTransaction()
            transcation?.replace(com.example.transporttvapp.R.id.fragment_content, fragment)
            transcation?.commit()


        }


    }
}
