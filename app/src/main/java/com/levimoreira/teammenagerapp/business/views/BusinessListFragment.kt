package com.levimoreira.teammenagerapp.business.views


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.business.adapters.BusinessListAdapter
import com.levimoreira.teammenagerapp.business.viewmodel.BusinessListViewModel
import com.levimoreira.teammenagerapp.main.OnActivityCallback
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_business.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */

class BusinessListFragment : DaggerFragment(), LifecycleOwner {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: BusinessListViewModel

    lateinit var adapter: BusinessListAdapter


    var businessList = mutableListOf<Business>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(BusinessListViewModel::class.java)
        adapter = BusinessListAdapter(businessList)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.clickListener = { business ->
            Toast.makeText(this.context, business.title, Toast.LENGTH_SHORT).show()
        }

        businessRecyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this.context)
        businessRecyclerView.adapter = adapter

        addBusiness.setOnClickListener {
            it.findNavController().navigate(R.id.action_businessListFragment_to_businessAddFragment)
        }

        viewModel.getAllBusiness().observe(this, Observer {
            it?.let {
                businessList.clear()
                businessList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    companion object {
        val TAG = "BusinessListFragment"
    }

}
