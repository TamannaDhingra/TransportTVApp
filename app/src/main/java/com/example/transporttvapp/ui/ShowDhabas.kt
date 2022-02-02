
package com.example.transporttvapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.transporttvapp.R
import com.example.transporttvapp.builderobjects.RetroBuilder
import com.example.transporttvapp.databinding.ActivityShowDhabasBinding

import com.example.transporttvapp.model.Dhaba

import com.example.transporttvapp.repository.Repostries
import com.example.transporttvapp.retroApi.RetroApi
import com.example.transporttvapp.ui.adapter.ShowDhabasAdapter
import com.example.transporttvapp.viewmodel.GetCurrentLocation
import com.example.transporttvapp.viewmodel.GetCurrentLocationFactory

class ShowDhabas : AppCompatActivity() {
    lateinit var binding: ActivityShowDhabasBinding


    lateinit var list: ArrayList<Dhaba>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_dhabas)
        list = arrayListOf()
        val intent = getIntent()
        var getLat = intent.getStringExtra("location_latitude")
        var getLong = intent.getStringExtra("location_longitude")
        // Toast.makeText(this, getLat + getLong, Toast.LENGTH_LONG).show()

        //binding.shimmerViewContainer.startShimmer()

        binding.progressBarShowdhabas.visibility= View.VISIBLE

        val retro = RetroBuilder.AllDhabaDetails().create(RetroApi::class.java)
        val repo = Repostries(retro, this)
        val viewmodel = ViewModelProvider(
            this,
            GetCurrentLocationFactory(repo)
        ).get(GetCurrentLocation::class.java)

         viewmodel.getLocation(getLat.toString(), getLong.toString())

        viewmodel.data1.observe(this, Observer {

            it.data?.let {

               /* Log.d("TAG", "onCreate:checkdhabaid "+ it.get(0).dhaba._id)
                Log.d("TAG", "onCreate:check_Owner_id "+ it.get(0).owner._id)*/
                val recyclerAdapter = ShowDhabasAdapter(this, it)
                binding.showDhabaRecycler.layoutManager = LinearLayoutManager(this@ShowDhabas)
                binding.showDhabaRecycler.adapter = recyclerAdapter
               binding.progressBarShowdhabas.visibility=View.GONE



            }


        })
    }
}





