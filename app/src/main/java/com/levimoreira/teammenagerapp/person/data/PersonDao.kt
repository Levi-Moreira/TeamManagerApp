package com.levimoreira.teammenagerapp.person.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.levimoreira.teammenagerapp.application.entities.Person
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface PersonDao {
    @Query("SELECT * from " + Person.TABLE_NAME)
    fun getAll(): Single<List<Person>>

    @Insert(onConflict = REPLACE)
    fun insert(person: Person): Long

    @Query("SELECT * FROM " + Person.TABLE_NAME + " WHERE id = :personId")
    fun getPersonById(personId: Long): Maybe<Person>

    @Query("DELETE FROM " + Person.TABLE_NAME + " WHERE id = :personId")
    fun deleteById(personId: Long): Int
}