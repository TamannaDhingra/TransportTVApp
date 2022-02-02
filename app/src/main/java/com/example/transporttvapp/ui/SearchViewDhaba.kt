package com.example.transporttvapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivitySearchViewDhabaBinding
import com.example.transporttvapp.model.LocationsDataClass
import com.example.transporttvapp.ui.adapter.SearchDhabaAdapter

import java.util.*

import java.util.Locale.filter
import kotlin.collections.ArrayList
import android.text.Editable
import androidx.compose.ui.text.toLowerCase
import java.util.Locale.getDefault


class SearchViewDhaba : AppCompatActivity() {
    lateinit var binding: ActivitySearchViewDhabaBinding
    val arrayList = ArrayList<LocationsDataClass>()
    val temparrayList = ArrayList<LocationsDataClass>()
    val displayList = ArrayList<LocationsDataClass>()
    lateinit var context: Context
   // val myAdapter = SearchDhabaAdapter(arrayList, this)
    val myAdapter = SearchDhabaAdapter(temparrayList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_view_dhaba)

        context = this

        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Abohar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Chandigarh", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Ludhiana", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Delhi", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Mohali", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        arrayList.add(LocationsDataClass("Amritsar", "Amritsar,GT Road 15", R.drawable.loading))
        displayList.addAll(arrayList)
        temparrayList.addAll(arrayList)


        binding.searchlistRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.searchlistRecyclerview.adapter = myAdapter

        /**
         * For Custom EditText SearchView
         */

        /*   binding.etsearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                
            }
            override fun afterTextChanged(editable: Editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString())
            }
        })




    }

    private fun filter(text: String) {
        //new array list that will hold the filtered data
        val filterdNames: ArrayList<LocationsDataClass> = ArrayList()
            //val filteredNames = ArrayList<LocationsDataClass>()

        //looping through existing elements
        for (s in displayList) {
            //if the existing elements contains the search input
            if ( s.city.toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s)
            }
        }

        //calling a method of the adapter class and passing the filtered list
       // val myAdapter = SearchDhabaAdapter(arrayList, this)
        myAdapter.filterlist(filterdNames)


         */


        /**
         * If we use direct searchview widget in xml file
         */

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                temparrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    arrayList.forEach {
                        if (it.city.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            temparrayList.add(it)
                        }
                    }
                    myAdapter.notifyDataSetChanged()
                } else {
                    temparrayList.clear()
                    temparrayList.addAll(arrayList)
                    myAdapter.notifyDataSetChanged()
                }


                return false
            }

        })

    }

    /**
     * If we use searchview in toolbar using menu
     */

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_item,menu)
        val item =menu?.findItem(R.id.search_bar)
        val searchView=item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                temparrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    arrayList.forEach {
                        if (it.city.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            temparrayList.add(it)
                        }
                    }
                    myAdapter.notifyDataSetChanged()
                } else {
                    temparrayList.clear()
                    temparrayList.addAll(arrayList)
                    myAdapter.notifyDataSetChanged()
                }


                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }*/
}


