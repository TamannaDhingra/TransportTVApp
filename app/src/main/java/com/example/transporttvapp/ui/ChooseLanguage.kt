package com.example.transporttvapp.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivityChooseLanguageBinding
import java.util.*

class ChooseLanguage : AppCompatActivity() {
    lateinit var binding: ActivityChooseLanguageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_choose_language)

        //for change language in Active State
       binding.engtv.setOnClickListener {
          binding.English.setTextColor(Color.RED)
            binding.ivCheckEnglish.visibility= View.VISIBLE

           changeLanguage("English")
            openLoginPage()
        }

        binding.hinditv.setOnClickListener {
            binding.Hindi.setTextColor(Color.RED)
            binding.ivCheckHindi.visibility= View.VISIBLE
            changeLanguage("Hindi")
            openLoginPage()
        }

        binding.punjabitv.setOnClickListener {
            binding.Punjabi.setTextColor(Color.RED)
            binding.ivCheckPunjabi.visibility= View.VISIBLE
            changeLanguage("Punjabi")
            openLoginPage()
        }



    }

    private fun openLoginPage() {
        val intent = Intent(this,LoginWithMobileNum::class.java)
        startActivity(intent)
    }


    fun changeLanguage(language: String){
        //    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        //   val language = sharedPreferences.getString("language","bar")
        // Toast.makeText(applicationContext,language,Toast.LENGTH_SHORT).show()
        if(language=="English"){
            Toast.makeText(applicationContext,"English", Toast.LENGTH_SHORT).show()
           language("")
        }
         else if(language=="Hindi"){
            Toast.makeText(applicationContext,"Hindi", Toast.LENGTH_SHORT).show()
           language("hi")
        }
        else {
            (language == "Punjabi")
            Toast.makeText(applicationContext, "Punjabi", Toast.LENGTH_SHORT).show()
            language("pa")
        }

    }



    fun language(language: String){
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = getResources()
        val configuration = resources.getConfiguration()
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.getDisplayMetrics())
       // Log.d("TAG", "language: fun lang selected ")
    }

    override fun onResume() {
        super.onResume()
        binding.Punjabi.setTextColor(Color.GRAY)
        binding.ivCheckPunjabi.visibility= View.GONE

        binding.Hindi.setTextColor(Color.GRAY)
        binding.ivCheckHindi.visibility= View.GONE

        binding.English.setTextColor(Color.GRAY)
        binding.ivCheckEnglish.visibility= View.GONE


    }

}