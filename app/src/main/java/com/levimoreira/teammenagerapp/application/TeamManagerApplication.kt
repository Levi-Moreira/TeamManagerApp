package com.levimoreira.teammenagerapp.application

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.levimoreira.teammenagerapp.application.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class TeamManagerApplication : Application(), HasSupportFragmentInjector {
    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var supportFragmentDispatchingAndroidInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    private fun initDagger() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<androidx.fragment.app.Fragment> {
        return supportFragmentDispatchingAndroidInjector
    }
}