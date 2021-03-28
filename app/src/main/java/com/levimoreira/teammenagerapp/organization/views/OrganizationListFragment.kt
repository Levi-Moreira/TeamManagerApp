package com.levimoreira.teammenagerapp.organization.views

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.databinding.FragmentOrganizationBinding
import com.levimoreira.teammenagerapp.organization.adapters.OrganizationListAdapter
import com.levimoreira.teammenagerapp.organization.viewmodel.OrganizationListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrganizationListFragment : Fragment(R.layout.fragment_organization) {
    private var _binding: FragmentOrganizationBinding? = null
    private val binding get() = _binding!!

    //  ViewModels
    private val organizationListViewModel: OrganizationListViewModel by viewModels()

    private lateinit var adapter: OrganizationListAdapter

    var organizationList = mutableListOf<Organization>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        subscribeToObserver()

        adapter = OrganizationListAdapter(organizationList)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_organization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOrganizationBinding.bind(view)

        adapter.clickListener = { person ->
            Toast.makeText(requireContext(), person.name, Toast.LENGTH_SHORT).show()
        }

        binding.apply {
            organizationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            organizationRecyclerView.adapter = adapter

            addOrganization.setOnClickListener {
                findNavController().navigate(R.id.action_organizationListFragment_to_organizationAddFragment)
            }
        }
    }

    private fun subscribeToObserver() {
        organizationListViewModel.organizations.observe(viewLifecycleOwner, Observer {
            it?.let {
                organizationList.clear()
                organizationList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
