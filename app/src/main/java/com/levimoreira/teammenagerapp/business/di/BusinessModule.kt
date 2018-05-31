package com.levimoreira.teammenagerapp.business.di

import android.arch.lifecycle.ViewModel
import com.levimoreira.teammenagerapp.application.di.ViewModelKey
import com.levimoreira.teammenagerapp.business.viewmodel.BusinessItemViewModel
import com.levimoreira.teammenagerapp.business.viewmodel.BusinessListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BusinessModule {
    @Binds
    @IntoMap
    @ViewModelKey(BusinessItemViewModel::class)
    abstract fun bindsBusinessItemViewModel(businessItemViewModel: BusinessItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BusinessListViewModel::class)
    abstract fun bindsBusinessListViewModel(businessListViewModel: BusinessListViewModel): ViewModel
}