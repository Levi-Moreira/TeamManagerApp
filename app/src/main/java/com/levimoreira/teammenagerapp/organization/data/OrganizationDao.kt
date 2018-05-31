package com.levimoreira.teammenagerapp.organization.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.application.entities.Person
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface OrganizationDao {
    @Query("SELECT * from " + Organization.TABLE_NAME)
    fun getAll(): Single<List<Organization>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(org: Organization): Long

    @Query("SELECT * FROM " + Organization.TABLE_NAME + " WHERE id = :orgId")
    fun getOrganizationById(orgId: Long): Maybe<Organization>

    @Query("DELETE FROM " + Organization.TABLE_NAME + " WHERE id = :org")
    fun deleteById(org: Long): Int
}