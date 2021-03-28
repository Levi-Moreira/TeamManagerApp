//package com.levimoreira.teammenagerapp.application.di
//
//import com.levimoreira.teammenagerapp.business.data.BusinessDao
//import com.levimoreira.teammenagerapp.business.data.BusinessRepository
//import com.levimoreira.teammenagerapp.organization.data.OrganizationDao
//import com.levimoreira.teammenagerapp.organization.data.OrganizationRepository
//import com.levimoreira.teammenagerapp.person.data.PersonDao
//import com.levimoreira.teammenagerapp.person.data.PersonRepository
//import dagger.Module
//import dagger.Provides
//import javax.inject.Singleton
//
//@Module
//class RepositoryModule {
//    @Provides
//    @Singleton
//    fun providePersonRepository(personDao: PersonDao): PersonRepository {
//        return PersonRepository(personDao)
//    }
//
//    @Provides
//    @Singleton
//    fun provideOrganizationRepository(organizationDao: OrganizationDao): OrganizationRepository {
//        return OrganizationRepository(organizationDao)
//    }
//
//    @Provides
//    @Singleton
//    fun provideBusinessRepository(businessDao: BusinessDao): BusinessRepository {
//        return BusinessRepository(businessDao)
//    }
//}