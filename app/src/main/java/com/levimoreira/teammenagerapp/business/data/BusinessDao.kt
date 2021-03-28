package com.levimoreira.teammenagerapp.business.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.application.entities.Organization
import io.reactivex.Maybe
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

@Dao
interface BusinessDao {
    @Query("SELECT * from " + Business.TABLE_NAME)
    fun getAll(): Flow<List<Business>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(business: Business): Long

    @Query("SELECT * FROM " + Business.TABLE_NAME + " WHERE id = :businessId")
    fun getBusinessById(businessId: Long): Flow<Business>

    @Query("DELETE FROM " + Business.TABLE_NAME + " WHERE id = :businessId")
    suspend fun deleteById(businessId: Long): Int
}