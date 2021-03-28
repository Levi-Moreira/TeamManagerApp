package com.levimoreira.teammenagerapp.person.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.levimoreira.teammenagerapp.application.entities.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Query("SELECT * from person")
    fun getAll(): Flow<List<Person>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(person: Person): Long

    @Query("SELECT * FROM person WHERE id = :personId")
    fun getPersonById(personId: Long): Flow<Person>

    @Query("DELETE FROM person WHERE id = :personId")
    suspend fun deleteById(personId: Long): Int
}