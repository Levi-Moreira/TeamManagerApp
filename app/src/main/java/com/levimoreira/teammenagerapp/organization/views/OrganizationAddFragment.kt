package com.levimoreira.teammenagerapp.organization.views

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.databinding.FragmentAddOrganizationBinding
import com.levimoreira.teammenagerapp.organization.viewmodel.OrganizationItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrganizationAddFragment : Fragment(R.layout.fragment_add_organization), View.OnClickListener {
    private var _binding: FragmentAddOrganizationBinding? = null
    private val binding get() = _binding!!

    //  ViewModels
    private val organizationItemViewModel: OrganizationItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddOrganizationBinding.bind(view)

        binding.createOrganizationButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.createOrganizationButton -> {
                createOrganization()
            }
        }
    }

    private fun createOrganization() {
        binding.apply {
            val organization = Organization(
                id = 0,
                name = inputName.text.toString(),
                phone = inputPhone.text.toString(),
                address = inputAddress.text.toString()
            )
            organizationItemViewModel.createOrganization(organization)
            Snackbar.make(binding.root, R.string.organization_created, Snackbar.LENGTH_SHORT).show()
        }
        findNavController().popBackStack()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
