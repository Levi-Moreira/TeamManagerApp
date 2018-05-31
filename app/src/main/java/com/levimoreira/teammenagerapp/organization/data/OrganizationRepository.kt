package com.levimoreira.teammenagerapp.organization.data

import com.levimoreira.teammenagerapp.application.entities.Organization
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class OrganizationRepository @Inject constructor(private var dao: OrganizationDao) {
    fun getOrganizationList(): Single<List<Organization>> {
        return dao.getAll()
    }

    fun getSingleOrganization(id: Long): Maybe<Organization> {
        return dao.getOrganizationById(id)
    }

    fun insertOrganization(org: Organization): Single<Long> {
        return Single.fromCallable {
            dao.insert(org)
        }
    }

    fun deleteOrganization(id: Long): Single<Int> {
        return Single.fromCallable {
            dao.deleteById(id)
        }
    }


}