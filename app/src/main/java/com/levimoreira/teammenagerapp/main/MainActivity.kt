package com.levimoreira.teammenagerapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.levimoreira.teammenagerapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val BACK_STACK_ROOT_TAG = "root_fragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViews()
    }

    private fun setUpViews() {
        navigation.setupWithNavController(Navigation.findNavController(this, R.id.my_nav_host_fragment))

        navigation.setOnNavigationItemSelectedListener { item ->

            //            onNavDestinationSelected(item, Navigation.findNavController(this, R.id.my_nav_host_fragment))
            Toast.makeText(this, item.itemId.toString(), Toast.LENGTH_SHORT).show()

            val fragmentId = Navigation.findNavController(this, R.id.my_nav_host_fragment).currentDestination.id

            val fragment = supportFragmentManager.findFragmentById(fragmentId)

            Log.e("MainActivity", fragment?.toString())

            return@setOnNavigationItemSelectedListener true

        }
        setupActionBarWithNavController(this, Navigation.findNavController(this, R.id.my_nav_host_fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }
}
