package com.levimoreira.teammenagerapp.person.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.levimoreira.teammenagerapp.person.data.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonListViewModel @Inject constructor(private val personRepository: PersonRepository) :
    ViewModel() {

    private var _allPersons = personRepository.getPersonsList().asLiveData()
    val allPersons = _allPersons
}