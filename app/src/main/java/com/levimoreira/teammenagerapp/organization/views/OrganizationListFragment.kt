package com.levimoreira.teammenagerapp.organization.views


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.main.OnActivityCallback
import com.levimoreira.teammenagerapp.organization.adapters.OrganizationListAdapter
import com.levimoreira.teammenagerapp.organization.viewmodel.OrganizationListViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_organization.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class OrganizationListFragment : DaggerFragment(), LifecycleOwner {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: OrganizationListViewModel

    lateinit var adapter: OrganizationListAdapter

    var organizationList = mutableListOf<Organization>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OrganizationListViewModel::class.java)
        adapter = OrganizationListAdapter(organizationList)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_organization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.clickListener = { person ->
            Toast.makeText(this.context, person.name, Toast.LENGTH_SHORT).show()
        }

        organizationRecyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this.context)
        organizationRecyclerView.adapter = adapter

        addOrganization.setOnClickListener {
            it.findNavController().navigate(R.id.action_organizationListFragment_to_organizationAddFragment)
        }

        viewModel.getAllOrganizations().observe(this, Observer {
            it?.let {
                organizationList.clear()
                organizationList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    companion object {
        val TAG = "OrganizationListFragment"
    }

}
