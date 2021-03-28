package com.levimoreira.teammenagerapp.organization.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.organization.data.OrganizationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrganizationItemViewModel @Inject constructor(private var organizationRepository: OrganizationRepository) : ViewModel() {

    fun getOrganization(organizationId: Long): LiveData<Organization> = organizationRepository.getSingleOrganization(organizationId).asLiveData()

    fun createOrganization(organization: Organization) = viewModelScope.launch {
        organizationRepository.insertOrganization(organization)
    }
}