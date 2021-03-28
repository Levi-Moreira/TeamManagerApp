package com.levimoreira.teammenagerapp.organization.data

import com.levimoreira.teammenagerapp.application.entities.Organization
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrganizationRepository @Inject constructor(private var dao: OrganizationDao) {

    fun getOrganizationList(): Flow<List<Organization>> {
        return dao.getAll()
    }

    fun getSingleOrganization(id: Long): Flow<Organization> {
        return dao.getOrganizationById(id)
    }

    suspend fun insertOrganization(org: Organization): Long {
        return dao.insert(org)
    }

    suspend fun deleteOrganization(id: Long): Int {
        return dao.deleteById(id)
    }
}