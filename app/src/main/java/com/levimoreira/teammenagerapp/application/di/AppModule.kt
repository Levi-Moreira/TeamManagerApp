package com.levimoreira.teammenagerapp.application.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.levimoreira.teammenagerapp.application.data.AppDatabase
import com.levimoreira.teammenagerapp.business.data.BusinessDao
import com.levimoreira.teammenagerapp.business.data.BusinessRepository
import com.levimoreira.teammenagerapp.organization.data.OrganizationDao
import com.levimoreira.teammenagerapp.organization.data.OrganizationRepository
import com.levimoreira.teammenagerapp.person.data.PersonDao
import com.levimoreira.teammenagerapp.person.data.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by mj on 2021/03/27 at 2:25 PM
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "TeamManagerApp.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun providePersonDao(database: AppDatabase): PersonDao {
        return database.personDao()
    }

    @Provides
    @Singleton
    fun provideOrganizationDao(database: AppDatabase): OrganizationDao {
        return database.organizationDao()
    }

    @Provides
    @Singleton
    fun provideBusinessDao(database: AppDatabase): BusinessDao {
        return database.businessDao()
    }

    @Provides
    @Singleton
    fun providePersonRepository(personDao: PersonDao): PersonRepository {
        return PersonRepository(personDao)
    }

    @Provides
    @Singleton
    fun provideOrganizationRepository(organizationDao: OrganizationDao): OrganizationRepository {
        return OrganizationRepository(organizationDao)
    }

    @Provides
    @Singleton
    fun provideBusinessRepository(businessDao: BusinessDao): BusinessRepository {
        return BusinessRepository(businessDao)
    }
}