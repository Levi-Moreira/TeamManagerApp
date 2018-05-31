package com.levimoreira.teammenagerapp.organization.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.organization.data.OrganizationRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OrganizationItemViewModel @Inject constructor(var organizationRepository: OrganizationRepository) : ViewModel() {
    fun createOrganization(organization: Organization): LiveData<Long> {
        val result = organizationRepository
                .insertOrganization(organization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable()

        return LiveDataReactiveStreams.fromPublisher(result)
    }
}