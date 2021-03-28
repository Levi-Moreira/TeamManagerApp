package com.levimoreira.teammenagerapp.application.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.business.data.BusinessDao
import com.levimoreira.teammenagerapp.organization.data.OrganizationDao
import com.levimoreira.teammenagerapp.person.data.PersonDao

@Database(entities = [(Person::class), (Organization::class), (Business::class)], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun organizationDao(): OrganizationDao
    abstract fun businessDao(): BusinessDao
}