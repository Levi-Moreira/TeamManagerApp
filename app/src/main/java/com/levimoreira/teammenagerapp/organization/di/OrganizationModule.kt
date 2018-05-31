package com.levimoreira.teammenagerapp.organization.di

import android.arch.lifecycle.ViewModel
import com.levimoreira.teammenagerapp.application.di.ViewModelKey
import com.levimoreira.teammenagerapp.organization.viewmodel.OrganizationItemViewModel
import com.levimoreira.teammenagerapp.organization.viewmodel.OrganizationListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class OrganizationModule {
    @Binds
    @IntoMap
    @ViewModelKey(OrganizationItemViewModel::class)
    abstract fun bindsOrganizationItemViewModel(organizationItemViewModel: OrganizationItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrganizationListViewModel::class)
    abstract fun bindsOrganizationListViewModel(organizationListViewModel: OrganizationListViewModel): ViewModel
}