package com.example.transporttvapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.transporttvapp.R


class ChooseLanguageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_choose_language, container, false)


/*

        val textview=view.findViewById<TextView>(R.id.English)
        textview.setOnClickListener{
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.framecontainer,LoginWithMoblie())?.commit()

        }
*/


        // Inflate the layout for this fragment
        return view
    }

}