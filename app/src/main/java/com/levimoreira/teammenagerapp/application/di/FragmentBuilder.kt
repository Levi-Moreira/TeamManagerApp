//package com.levimoreira.teammenagerapp.application.di
//
//import com.levimoreira.teammenagerapp.business.di.BusinessModule
//import com.levimoreira.teammenagerapp.business.views.BusinessAddFragment
//import com.levimoreira.teammenagerapp.business.views.BusinessListFragment
//import com.levimoreira.teammenagerapp.person.di.PersonModule
//import com.levimoreira.teammenagerapp.organization.views.OrganizationAddFragment
//import com.levimoreira.teammenagerapp.organization.di.OrganizationModule
//import com.levimoreira.teammenagerapp.organization.views.OrganizationListFragment
//import com.levimoreira.teammenagerapp.person.view.PersonAddFragment
//import com.levimoreira.teammenagerapp.person.view.PersonListFragment
//import dagger.Module
//import dagger.android.ContributesAndroidInjector
//
//@Module
//abstract class FragmentBuilder {
//    @ContributesAndroidInjector(modules = [(PersonModule::class)])
//    abstract fun bindAddPersonFragment(): PersonAddFragment
//
//    @ContributesAndroidInjector(modules = [(PersonModule::class)])
//    abstract fun bindListPersonFragment(): PersonListFragment
//
//    @ContributesAndroidInjector(modules = [(OrganizationModule::class)])
//    abstract fun bindOrganizationAddFragment(): OrganizationAddFragment
//
//    @ContributesAndroidInjector(modules = [(OrganizationModule::class)])
//    abstract fun bindOrganizationListFragment(): OrganizationListFragment
//
//    @ContributesAndroidInjector(modules = [(BusinessModule::class)])
//    abstract fun bindBusinessAddFragment(): BusinessAddFragment
//
//    @ContributesAndroidInjector(modules = [(BusinessModule::class)])
//    abstract fun bindBusinessListFragment(): BusinessListFragment
//}