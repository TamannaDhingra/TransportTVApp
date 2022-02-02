package com.example.transporttvapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter.FilterResults
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.transporttvapp.R
import com.example.transporttvapp.model.LocationsDataClass

class SearchDhabaAdapter(var arrayList12:ArrayList<LocationsDataClass>, val context: Context):
    RecyclerView.Adapter<SearchDhabaAdapter.ViewHolder>() {

    lateinit var templist:ArrayList<LocationsDataClass>
    lateinit var listfull:ArrayList<LocationsDataClass>





    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val city=itemView.findViewById<TextView>(R.id.citytext)
        val dhaba=itemView.findViewById<TextView>(R.id.dhabatext)
        val img=itemView.findViewById<ImageView>(R.id.loader)
        fun bindItems(model:LocationsDataClass){
            city.text=model.city
            dhaba.text=model.dhaba
            img.setImageResource(model.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.custom_search_list,parent,false)
        return ViewHolder(v)
    }



    fun filterlist(filterdNames: ArrayList<LocationsDataClass>) {
        this.arrayList12 = filterdNames
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList12[position])
    }

    override fun getItemCount(): Int {
        return arrayList12.size
    }





    /* //for searching
    fun getFilter(): Filter? {
        return exampleFilter
    }

    private val exampleFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filteredList: MutableList<LocationsDataClass> = java.util.ArrayList<LocationsDataClass>()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(listfull)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }
                for (item in listfull) {
                    if (item.city.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            arrayList.clear()
            arrayList.addAll(results.values as List<>)
            notifyDataSetChanged()
        }
    }*/

}