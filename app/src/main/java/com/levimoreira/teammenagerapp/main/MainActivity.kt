package com.levimoreira.teammenagerapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
    }

    private fun setUpViews() {
        binding.apply{
            navigation.setupWithNavController(Navigation.findNavController(this@MainActivity, R.id.my_nav_host_fragment))
            setupActionBarWithNavController(this@MainActivity, Navigation.findNavController(this@MainActivity, R.id.my_nav_host_fragment))
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }
}
