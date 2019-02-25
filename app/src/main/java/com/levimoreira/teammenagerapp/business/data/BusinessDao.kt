package com.levimoreira.teammenagerapp.business.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.application.entities.Business.Companion.COLUMN_PERSON
import com.levimoreira.teammenagerapp.application.entities.BusinessPerson
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.application.entities.Person
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface BusinessDao {
    @Query("SELECT * from " + Business.TABLE_NAME)
    fun getAll(): Single<List<Business>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(business: Business): Long

    @Query("SELECT * FROM " + Business.TABLE_NAME + " WHERE id = :businessId")
    fun getOrganizationById(businessId: Long): Maybe<Business>

    @Query("DELETE FROM " + Business.TABLE_NAME + " WHERE id = :businessId")
    fun deleteById(businessId: Long): Int

    @Query("SELECT * FROM " + Business.TABLE_NAME + " WHERE " + COLUMN_PERSON + " = :personId")
    fun businessFromPerson(personId: Long): Single<List<Business>>

    @Query("SELECT * FROM person INNER JOIN business_person ON person.id=business_person.personId WHERE business_person.businessId=:businessId")
    fun getPersonForBusiness(businessId: Long): Single<List<Person>>

    @Query("SELECT * FROM business INNER JOIN business_person ON business.id=business_person.businessId WHERE business_person.personId=:personId")
    fun getBusinessForPerson(personId: Long): Single<List<Business>>

}