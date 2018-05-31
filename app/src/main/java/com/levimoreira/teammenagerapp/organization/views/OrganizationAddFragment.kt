package com.levimoreira.teammenagerapp.organization.views


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.business.viewmodel.BusinessItemViewModel
import com.levimoreira.teammenagerapp.organization.viewmodel.OrganizationItemViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_add_organization.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class OrganizationAddFragment : DaggerFragment(), LifecycleOwner {
    val TAG = "OrganizationAddFragment"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: OrganizationItemViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OrganizationItemViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_organization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createOrganizationButton.setOnClickListener {
            val organization = Organization(id = null,
                    name = inputName.text.toString(),
                    phone = inputPhone.text.toString(),
                    address = inputAddress.text.toString())

            viewModel.createOrganization(organization).observe(this, Observer {
                this.view?.let { view ->
                    Snackbar.make(view, R.string.organization_created, Snackbar.LENGTH_SHORT).show()
                }
                findNavController().popBackStack()
            })
        }
    }

    companion object {
        val TAG = "OrganizationAddFragment"
    }


}
