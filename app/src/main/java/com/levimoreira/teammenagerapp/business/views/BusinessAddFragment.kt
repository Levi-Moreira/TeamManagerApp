package com.levimoreira.teammenagerapp.business.views


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.business.adapters.OrganizationSpinnerAdapter
import com.levimoreira.teammenagerapp.business.adapters.PersonSpinnerAdapter
import com.levimoreira.teammenagerapp.business.viewmodel.BusinessItemViewModel
import com.levimoreira.teammenagerapp.organization.viewmodel.OrganizationListViewModel
import com.levimoreira.teammenagerapp.person.viewmodel.PersonListViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_business_add.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class BusinessAddFragment : DaggerFragment(), LifecycleOwner {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var organizationViewModel: OrganizationListViewModel
    lateinit var organizationSpinnerAdapter: OrganizationSpinnerAdapter

    lateinit var personSpinnerAdapter: PersonSpinnerAdapter
    lateinit var personViewModel: PersonListViewModel

    lateinit var businessViewModel: BusinessItemViewModel

    var organizationList = mutableListOf<Organization>()
    var personList = mutableListOf<Person>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        organizationViewModel = ViewModelProviders.of(this, viewModelFactory).get(OrganizationListViewModel::class.java)
        organizationSpinnerAdapter = OrganizationSpinnerAdapter(this.context, organizationList)

        personSpinnerAdapter = PersonSpinnerAdapter(this.context, personList)
        personViewModel = ViewModelProviders.of(this, viewModelFactory).get(PersonListViewModel::class.java)

        businessViewModel = ViewModelProviders.of(this, viewModelFactory).get(BusinessItemViewModel::class.java)


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        organizationSpinner.adapter = organizationSpinnerAdapter
        personSpinner.adapter = personSpinnerAdapter

        organizationViewModel.getAllOrganizations().observe(this, Observer {
            it?.let {
                organizationList.addAll(it)
                organizationSpinnerAdapter.notifyDataSetChanged()
            }
        })

        personViewModel.getAllPersons().observe(this, Observer {
            it?.let {
                personList.addAll(it)
                personSpinnerAdapter.notifyDataSetChanged()
            }
        })

        createBusinessButton.setOnClickListener {
            val business = Business(id = null,
                    title = inputTitle.text.toString(),
                    description = inputDescription.text.toString(),
                    organizationId = organizationSpinner.selectedItemId,
                    personId = personSpinner.selectedItemId,
                    value = inputValue.text.toString(),
                    deadline = inputDeadline.text.toString(),
                    state = inputState.text.toString()
            )

            businessViewModel.createBusiness(business).observe(this, Observer {
                this.view?.let { view ->
                    Snackbar.make(view, R.string.business_created, Snackbar.LENGTH_SHORT).show()
                }
                findNavController().popBackStack()
            })
        }
    }

    companion object {
        val TAG = "BusinessAddFragment"
    }

}
