package com.example.transporttvapp.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivityShowRouteBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ShowRouteActivity : AppCompatActivity() {

    lateinit var binding:ActivityShowRouteBinding
    lateinit var mapFragment:SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_route)

        // binding = RouteDisplayMapsActivity.inflate(getLayoutInflater());

        //  manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        mapFragment=supportFragmentManager.findFragmentById(R.id.gmap) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap=it
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            )
            googleMap.isMyLocationEnabled=true

            val location1=LatLng(13.03,77.60)
            googleMap.addMarker(MarkerOptions().position(location1).title("Your Location"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,10f))
        })
    }
}