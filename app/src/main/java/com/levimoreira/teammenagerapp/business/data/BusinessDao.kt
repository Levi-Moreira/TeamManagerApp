package com.levimoreira.teammenagerapp.business.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.application.entities.Organization
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
}