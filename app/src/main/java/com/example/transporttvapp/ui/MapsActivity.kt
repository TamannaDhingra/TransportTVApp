package com.example.transporttvapp.ui


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivityMapsBinding
import com.google.android.gms.common.api.Response

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.androidgamesdk.gametextinput.Listener*/
import com.android.volley.Request
import org.json.JSONObject
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.PolyUtil


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
     override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18f))
        mMap.animateCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.uiSettings.setAllGesturesEnabled(true)
        mMap.uiSettings.isZoomControlsEnabled = true


    }

   /* override fun onMapReady(googleMap: GoogleMap?) {
       // this.googleMap = googleMap
        // Sample coordinates
      mMap= googleMap!!
        val latLngOrigin = LatLng(10.3181466, 123.9029382) // Ayala
        val latLngDestination = LatLng(10.311795,123.915864) // SM City
        mMap.addMarker(MarkerOptions().position(latLngOrigin).title("Ayala"))
        mMap.addMarker(MarkerOptions().position(latLngDestination).title("SM City"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngOrigin, 14.5f))
        val path: MutableList<List<LatLng>> = ArrayList()
        val urlDirections = "https://maps.googleapis.com/maps/api/directions/json?origin=10.3181466,123.9029382&destination=10.311795,123.915864&key=<AIzaSyDks7Xr05ZLmBK9_ZFAV_H5IkI3B9gM2Hs>"
        val directionsRequest = object : StringRequest(Method.GET, urlDirections, Response.Listener<String> {
                response ->
            val jsonResponse = JSONObject(response)
            // Get routes
            val routes = jsonResponse.getJSONArray("routes")
            val legs = routes.getJSONObject(0).getJSONArray("legs")
            val steps = legs.getJSONObject(0).getJSONArray("steps")
            for (i in 0 until steps.length()) {
                val points = steps.getJSONObject(i).getJSONObject("polyline").getString("points")
                path.add(PolyUtil.decode(points))
            }
            for (i in 0 until path.size) {
                mMap.addPolyline(PolylineOptions().addAll(path[i]).color(Color.RED))
            }
        }, Response.ErrorListener {
                _ ->
        }){}
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(directionsRequest)
    }*/

}