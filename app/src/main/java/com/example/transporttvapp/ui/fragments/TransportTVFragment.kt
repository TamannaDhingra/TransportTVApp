package com.example.transporttvapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.transporttvapp.databinding.FragmentTransportTV3Binding

import com.example.transporttvapp.ui.adapter.VideoAdapter
import com.example.transporttvapp.viewmodel.HomeScreenVideo

import com.example.transporttvapp.viewmodel.HomeScreenVideoFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.SimpleExoPlayerView


class TransportTVFragment() : Fragment() {
    // creating a variable for exoplayerview.
    lateinit var exoPlayerView: SimpleExoPlayerView

    // creating a variable for exoplayer
    lateinit var exoPlayer: SimpleExoPlayer


    var videoURL =
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4"

    lateinit var binding: FragmentTransportTV3Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentTransportTV3Binding.inflate(inflater, container, false)


        val viewmodel =
            ViewModelProvider(this, HomeScreenVideoFactory()).get(HomeScreenVideo::class.java)
        viewmodel.homeScreenVideo()


        viewmodel.datatemp.observe(viewLifecycleOwner, Observer {

            it?.let {

                it.data?.let {


                    val recyclerAdapter = it.data?.let { it1 ->
                        VideoAdapter(
                            requireActivity(),
                            it1
                        )
                    }

                    binding.videoRecycler.layoutManager = LinearLayoutManager(activity)
                    binding.videoRecycler.adapter = recyclerAdapter

                }
            }
        })




        /* val recyclerAdapter= VideoAdapter(requireActivity(),list)
        binding.videoRecycler.layoutManager= LinearLayoutManager(activity)
        binding.videoRecycler.adapter=recyclerAdapter
       */

        return binding.root

    }
}


