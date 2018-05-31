package com.levimoreira.teammenagerapp.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.levimoreira.teammenagerapp.home.HomeFragment
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.business.views.BusinessAddFragment
import com.levimoreira.teammenagerapp.business.views.BusinessListFragment
import com.levimoreira.teammenagerapp.organization.views.OrganizationAddFragment
import com.levimoreira.teammenagerapp.organization.views.OrganizationListFragment
import com.levimoreira.teammenagerapp.person.view.PersonAddFragment
import com.levimoreira.teammenagerapp.person.view.PersonListFragment
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
        setupActionBarWithNavController(this, Navigation.findNavController(this, R.id.my_nav_host_fragment))
    }


    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }

}
