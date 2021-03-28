//package com.levimoreira.teammenagerapp.application.di
//
//import android.app.Application
//import androidx.room.Room
//import com.levimoreira.teammenagerapp.application.data.AppDatabase
//import com.levimoreira.teammenagerapp.business.data.BusinessDao
//import com.levimoreira.teammenagerapp.organization.data.OrganizationDao
//import com.levimoreira.teammenagerapp.person.data.PersonDao
//import dagger.Module
//import javax.inject.Singleton
//import dagger.Provides
//
//
//@Module
//class RoomModule {
//
//    @Provides
//    @Singleton
//    fun providePersonDao(database: AppDatabase): PersonDao {
//        return database.personDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideOrganizationDao(database: AppDatabase): OrganizationDao {
//        return database.organizationDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideBusinessDao(database: AppDatabase): BusinessDao {
//        return database.businessDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideAppDatabase(application: Application): AppDatabase {
//        return Room
//                .databaseBuilder(application, AppDatabase::class.java, "TeamManagerApp.db")
//                .fallbackToDestructiveMigration()
//                .build()
//    }
//}