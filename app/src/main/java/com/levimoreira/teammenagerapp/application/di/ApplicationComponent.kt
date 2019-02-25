package com.levimoreira.teammenagerapp.application.di

import android.app.Application
import com.levimoreira.teammenagerapp.application.TeamManagerApplication
import com.levimoreira.teammenagerapp.business.di.BusinessModule
import com.levimoreira.teammenagerapp.organization.di.OrganizationModule
import com.levimoreira.teammenagerapp.person.di.PersonModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class),
    (FragmentBuilder::class),
    (DaggerViewModelFactoryModule::class),
    (RepositoryModule::class),
    (RoomModule::class),
    (PersonModule::class), OrganizationModule::class, BusinessModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: TeamManagerApplication)

}