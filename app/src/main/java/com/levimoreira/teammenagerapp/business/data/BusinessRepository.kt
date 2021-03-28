package com.levimoreira.teammenagerapp.business.data

import com.levimoreira.teammenagerapp.application.entities.Business
import io.reactivex.Maybe
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BusinessRepository @Inject constructor(private var dao: BusinessDao) {

    fun getBusinessList(): Flow<List<Business>> {
        return dao.getAll()
    }

    fun getSingleBusiness(id: Long): Flow<Business> {
        return dao.getBusinessById(id)
    }

    suspend fun insertBusiness(business: Business): Long {
        return dao.insert(business)

    }

    suspend fun deleteBusiness(id: Long): Int{
        return dao.deleteById(id)

    }


}