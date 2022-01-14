package com.example.transporttvapp.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivityChooseLanguageBinding

class ChooseLanguage : AppCompatActivity() {
    lateinit var binding: ActivityChooseLanguageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_choose_language)

        //for change language in Active State
       binding.English.setOnClickListener {
          binding.English.setTextColor(Color.RED)
            binding.ivCheckEnglish.visibility= View.VISIBLE
            openLoginPage()
        }

        binding.Hindi.setOnClickListener {
            binding.Hindi.setTextColor(Color.RED)
            binding.ivCheckHindi.visibility= View.VISIBLE
            openLoginPage()
        }

        binding.Punjabi.setOnClickListener {
            binding.Punjabi.setTextColor(Color.RED)
            binding.ivCheckPunjabi.visibility= View.VISIBLE
            openLoginPage()
        }







       // supportFragmentManager.beginTransaction().replace(R.id.framecontainer,ChooseLanguageFragment()).commit()



    }

    private fun openLoginPage() {
        val intent = Intent(this,LoginWithMobileNum::class.java)
        startActivity(intent)
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