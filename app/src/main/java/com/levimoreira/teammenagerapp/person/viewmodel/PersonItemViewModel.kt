package com.levimoreira.teammenagerapp.person.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.person.data.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonItemViewModel @Inject constructor(private var personRepository: PersonRepository) : ViewModel() {

    fun createPerson(person: Person) = viewModelScope.launch {
        personRepository.insertPerson(person)
    }
}