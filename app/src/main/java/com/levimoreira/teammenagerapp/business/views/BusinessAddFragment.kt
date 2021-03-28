package com.levimoreira.teammenagerapp.business.views

import androidx.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.business.adapters.OrganizationSpinnerAdapter
import com.levimoreira.teammenagerapp.business.adapters.PersonSpinnerAdapter
import com.levimoreira.teammenagerapp.business.viewmodel.BusinessItemViewModel
import com.levimoreira.teammenagerapp.databinding.FragmentBusinessAddBinding
import com.levimoreira.teammenagerapp.databinding.FragmentBusinessBinding
import com.levimoreira.teammenagerapp.organization.viewmodel.OrganizationListViewModel
import com.levimoreira.teammenagerapp.person.viewmodel.PersonListViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 *
 */
@AndroidEntryPoint
class BusinessAddFragment : Fragment(R.layout.fragment_business_add), View.OnClickListener {
    private var _binding: FragmentBusinessAddBinding? = null
    private val binding get() = _binding!!

    //  ViewModels
    private val businessItemViewModel: BusinessItemViewModel by viewModels()
     private val organizationListViewModel: OrganizationListViewModel by viewModels()
     private val personListViewModel: PersonListViewModel by viewModels()

    //  Adapters
    private lateinit var organizationSpinnerAdapter: OrganizationSpinnerAdapter
    private lateinit var personSpinnerAdapter: PersonSpinnerAdapter

    var organizationList = mutableListOf<Organization>()
    var personList = mutableListOf<Person>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        subscribeToObservers()

        organizationSpinnerAdapter = OrganizationSpinnerAdapter(requireContext(), organizationList)

        personSpinnerAdapter = PersonSpinnerAdapter(requireContext(), personList)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBusinessAddBinding.bind(view)

        binding.organizationSpinner.adapter = organizationSpinnerAdapter
        binding.personSpinner.adapter = personSpinnerAdapter
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.createBusinessButton -> {
                createBusiness()
            }
        }
    }

    private fun createBusiness() {
        binding.apply {
            val business = Business(
                id = null,
                title = inputTitle.text.toString(),
                description = inputDescription.text.toString(),
                organizationId = organizationSpinner.selectedItemId,
                personId = personSpinner.selectedItemId,
                value = inputValue.text.toString(),
                deadline = inputDeadline.text.toString(),
                state = inputState.text.toString()
            )
            businessItemViewModel.createBusiness(business)
            findNavController().popBackStack()
        }
    }

    private fun subscribeToObservers() {
        organizationListViewModel.organizations.observe(viewLifecycleOwner, Observer {
            it?.let {
                organizationList.addAll(it)
                organizationSpinnerAdapter.notifyDataSetChanged()
            }
        })

        personListViewModel.allPersons.observe(viewLifecycleOwner, Observer {
            it?.let {
                personList.addAll(it)
                personSpinnerAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
