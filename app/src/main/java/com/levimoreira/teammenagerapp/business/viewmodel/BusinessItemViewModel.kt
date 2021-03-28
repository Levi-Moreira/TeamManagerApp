package com.levimoreira.teammenagerapp.business.viewmodel

import androidx.lifecycle.*
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.business.data.BusinessRepository
import com.levimoreira.teammenagerapp.organization.data.OrganizationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusinessItemViewModel @Inject constructor(private var businessRepository: BusinessRepository) : ViewModel() {

    fun getSingleBusiness(businessId: Long): LiveData<Business> {
        return businessRepository.getSingleBusiness(businessId).asLiveData()
    }

    fun createBusiness(business: Business) = viewModelScope.launch { businessRepository.insertBusiness(business) }
}