package com.levimoreira.teammenagerapp.business.data

import com.levimoreira.teammenagerapp.application.entities.Business
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class BusinessRepository @Inject constructor(private var dao: BusinessDao) {
    fun getBusinessList(): Single<List<Business>> {
        return dao.getAll()
    }

    fun getSingleBusiness(id: Long): Maybe<Business> {
        return dao.getOrganizationById(id)
    }

    fun insertBusiness(business: Business): Single<Long> {
        return Single.fromCallable {
            dao.insert(business)
        }
    }

    fun deleteBusiness(id: Long): Single<Int> {
        return Single.fromCallable {
            dao.deleteById(id)
        }
    }


}