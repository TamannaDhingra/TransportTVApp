package com.example.transporttvapp.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivitySearchViewDhabaBinding
import com.example.transporttvapp.model.LocationsDataClass

class SearchViewDhaba : AppCompatActivity() {
    lateinit var binding: ActivitySearchViewDhabaBinding

    lateinit var list:ArrayList<LocationsDataClass>
    lateinit var templist:ArrayList<LocationsDataClass>
lateinit var context: Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_view_dhaba)


      /*binding.crossimageView.setOnClickListener {
          val intent=Intent(this,DhabaFragment::class.java)
          startActivity(intent)
      }

*/




       /* context=this
        val img= intArrayOf(R.drawable.loading,R.drawable.loading,R.drawable.loading,R.drawable.loading)
        val city= arrayOf("Amritsar","Amritsar","Amritsar","Amritsar")
        val dhaba= arrayOf("Amritsar,Ranjit Dhaba","Amritsar,Ranjit Dhaba","Amritsar,Ranjit Dhaba","Amritsar,Ranjit Dhaba")

/*
        val locationsAdapter:ArrayAdapter<String> =
            ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,locations)

        binding.searchlist.adapter=locationsAdapter;*/

        list=ArrayList()
        for (i in city.indices) {
            val locationList = LocationsDataClass()
            locationList.img=img[i]
            locationList.city=city[i]
            locationList.dhaba=dhaba[i]

            list.add(i,locationList)

        }

        binding.searchlistListview.isClickable=true
        binding.searchlistListview.adapter=SearchlistListviewAdapter(this,list)


        binding.searchBar.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchBar.clearFocus()

                /*if (list.contains(query)){
                    SearchlistListviewAdapter.filter.filter(query)
                }*/
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
             //  SearchlistListviewAdapter.filter.filter(newText)

                if (newText.toString().equals(""))
                {
                    binding.searchlistListview.adapter=SearchlistListviewAdapter(context,list)
                }
                else {
                    for (i in list) {
                        if (i.city.toString().trim().contains(newText.toString().trim())) {
                            templist.add(i)
                            binding.searchlistListview.adapter =
                                SearchlistListviewAdapter(context, templist)

                        }
                    }
                }



                return false
            }

        })
*/
    }

}