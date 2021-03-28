package com.levimoreira.teammenagerapp.organization.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.levimoreira.teammenagerapp.organization.data.OrganizationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrganizationListViewModel @Inject constructor(private var organizationRepository: OrganizationRepository) : ViewModel() {

    private var _organizations = organizationRepository.getOrganizationList().asLiveData()
    val organizations = _organizations
}