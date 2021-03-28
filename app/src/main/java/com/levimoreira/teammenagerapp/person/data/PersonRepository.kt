package com.levimoreira.teammenagerapp.person.data

import com.levimoreira.teammenagerapp.application.entities.Person
import io.reactivex.FlowableEmitter
import io.reactivex.Maybe
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonRepository @Inject constructor(private var dao: PersonDao) {

    fun getPersonsList(): Flow<List<Person>> {
        return dao.getAll()
    }

    fun getSinglePerson(id: Long): Flow<Person> {
        return dao.getPersonById(id)
    }

    suspend fun insertPerson(person: Person): Long {
        return dao.insert(person)
    }

    suspend fun deletePerson(id: Long): Int {
        return dao.deleteById(id)
    }
}