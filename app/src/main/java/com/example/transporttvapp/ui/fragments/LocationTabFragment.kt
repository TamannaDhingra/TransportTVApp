package com.example.transporttvapp.ui.fragments

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.transporttvapp.R
import com.example.transporttvapp.builderobjects.RetroBuilder
import com.example.transporttvapp.databinding.FragmentDhabaBinding
import com.example.transporttvapp.databinding.FragmentLocationTabBinding
import com.example.transporttvapp.databinding.FragmentTransportTV3Binding
import com.example.transporttvapp.repository.Repostries
import com.example.transporttvapp.retroApi.RetroApi
import com.example.transporttvapp.ui.LoginWithMobileNum

import com.example.transporttvapp.ui.SearchViewDhaba
import com.example.transporttvapp.ui.ShowDhabas
import com.example.transporttvapp.ui.VerifyMobileNum
import com.example.transporttvapp.viewmodel.*
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import java.util.*
import java.util.jar.Manifest

class LocationTabFragment(val context2: Context, val context: Activity) : Fragment() {
    lateinit var binding: FragmentLocationTabBinding


    private lateinit var fusedlocation: FusedLocationProviderClient
    private lateinit var marker: Marker
    private lateinit var locationRequest: LocationRequest
    var location: Location? = null
    lateinit var geocoder: Geocoder
    lateinit var locationtemp: String
    lateinit var viewmodel: GetCurrentLocation


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fusedlocation = LocationServices.getFusedLocationProviderClient(context2)
        locationRequest = LocationRequest.create()
        locationRequest.interval = 0
        locationRequest.fastestInterval = 10
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY



        binding = FragmentLocationTabBinding.inflate(inflater, container, false)

        //get Current Location using fused location
        fusedlocation = LocationServices.getFusedLocationProviderClient(context)
        checkLocationPermission()


        val retro = RetroBuilder.UserData().create(RetroApi::class.java)
        val repo = Repostries(retro, context2)
        val viewmodel = ViewModelProvider(
            this,
            GetCurrentLocationFactory(repo)
        ).get(GetCurrentLocation::class.java)

        checkLocationPermission()

        // viewmodel.getLocation(locationtemp.latitude.toString(), locationtemp.longitude.toString())
        /* viewmodel.data1.observe(context2, Observer {
            val temp = it.data?.get(0)
       })
*/



        binding.layoutForLocationTab.setOnClickListener {
            location?.let {
                val intent = Intent(context, ShowDhabas::class.java)
                intent.putExtra("location_latitude", it.latitude.toString())
                intent.putExtra("location_longitude", it.longitude.toString())
                startActivity(intent)
            }


        }


        binding.searchBarClick.setOnClickListener {
            val intent = Intent(context, SearchViewDhaba::class.java)
            startActivity(intent)

        }

        return binding.root
    }

    private fun checkLocationPermission() {


        ActivityCompat.checkSelfPermission(
            context2,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    context2,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED

        fusedlocation.requestLocationUpdates(
            locationRequest,
            locationCallback1,
            Looper.getMainLooper()
        )

    }

    var locationCallback1: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            location = locationResult.lastLocation


            location?.let {
               binding.tvcurrentLocation.text = getCityname(it.latitude, it.longitude)
            }
            //  location.latitude.toString() + location.longitude.toString()


            //viewmodel.getLocation(location.latitude.toString(), location.longitude.toString())
            super.onLocationResult(locationResult)
        }
    }


    fun getCityname(lat: Double, long: Double): String {
        var cityName = ""
        var geoCoder = Geocoder(context2, Locale.getDefault())
        var Address: MutableList<Address> = geoCoder.getFromLocation(lat, long, 1)

        cityName = Address.get(0).locality


        return cityName

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == 100) {
            Toast.makeText(context2, "granted", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context2, "denied!", Toast.LENGTH_LONG).show()
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}

