package com.levimoreira.teammenagerapp.business.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.business.data.BusinessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BusinessListViewModel @Inject constructor(private var businessRepository: BusinessRepository) : ViewModel() {

    private var _allBusinesses = businessRepository.getBusinessList()
    val allBusinesses:LiveData<List<Business>> = _allBusinesses.asLiveData()
}