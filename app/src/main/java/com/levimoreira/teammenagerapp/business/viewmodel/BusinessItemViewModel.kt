package com.levimoreira.teammenagerapp.business.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.business.data.BusinessRepository
import com.levimoreira.teammenagerapp.organization.data.OrganizationRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BusinessItemViewModel @Inject constructor(var businessRepository: BusinessRepository) : ViewModel() {
    fun createBusiness(business: Business): LiveData<Long> {
        val result = businessRepository
                .insertBusiness(business)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable()

        return LiveDataReactiveStreams.fromPublisher(result)
    }
}