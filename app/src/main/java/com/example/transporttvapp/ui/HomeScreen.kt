package com.example.transporttvapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.transporttvapp.R
import com.example.transporttvapp.databinding.ActivityBottomNavBinding
import com.example.transporttvapp.ui.fragments.DhabaFragment
import com.example.transporttvapp.ui.fragments.TransportTVFragment
import com.google.android.material.navigation.NavigationView

class HomeScreen : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavBinding
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var navi:NavigationView
    lateinit var toolbar: Toolbar
    lateinit var Drawer:DrawerLayout



  private val transportTVFragment=TransportTVFragment()
    private val dhabaFragment=DhabaFragment(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_bottom_nav)
        Drawer=binding.drawer
        navi=binding.navmenu
        toolbar=binding.toolbar
        toggle= ActionBarDrawerToggle(this,Drawer,toolbar,R.string.open,R.string.close)
        Drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        replaceFragment(transportTVFragment)

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.transport_tv_menu->replaceFragment(transportTVFragment)
                R.id.dhabamenu->replaceFragment(dhabaFragment)

            }
            true

        }

        navi.setNavigationItemSelectedListener {

            it.isChecked()
            when(it.itemId){
                R.id.nav_transporttv->replaceFragment(transportTVFragment)
                R.id.nav_dhaba->replaceFragment(dhabaFragment)
            }
            true
        }

    }

     fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transcation=supportFragmentManager.beginTransaction()
            transcation.replace(R.id.fragment_container,fragment)
            transcation.commit()
            Drawer.closeDrawers()

        }

    }
}