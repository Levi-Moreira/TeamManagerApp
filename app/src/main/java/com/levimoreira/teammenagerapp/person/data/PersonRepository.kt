package com.levimoreira.teammenagerapp.person.data

import com.levimoreira.teammenagerapp.application.entities.Person
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class PersonRepository @Inject constructor(private var dao: PersonDao) {
    fun getPersonList(): Single<List<Person>> {
        return dao.getAll()
    }

    fun getSinglePerson(id: Long): Maybe<Person> {
        return dao.getPersonById(id)
    }

    fun insertPerson(person: Person): Single<Long> {
        return Single.fromCallable {
            dao.insert(person)
        }
    }

    fun deletePerson(id: Long): Single<Int> {
        return Single.fromCallable {
            dao.deleteById(id)
        }
    }


}