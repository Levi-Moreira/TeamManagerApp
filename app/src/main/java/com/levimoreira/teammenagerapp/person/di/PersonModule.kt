package com.levimoreira.teammenagerapp.person.di

import android.arch.lifecycle.ViewModel
import com.levimoreira.teammenagerapp.application.di.ViewModelKey
import com.levimoreira.teammenagerapp.person.viewmodel.PersonItemViewModel
import com.levimoreira.teammenagerapp.person.viewmodel.PersonListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PersonModule {
    @Binds
    @IntoMap
    @ViewModelKey(PersonItemViewModel::class)
    abstract fun bindsPersonItemViewModel(personItemViewModel: PersonItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonListViewModel::class)
    abstract fun bindsPersonListViewModel(personListViewModel: PersonListViewModel): ViewModel
}