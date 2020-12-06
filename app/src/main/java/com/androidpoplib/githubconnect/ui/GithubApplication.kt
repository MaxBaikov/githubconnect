package com.androidpoplib.githubconnect.ui

import android.app.Application
import com.androidpoplib.githubconnect.di.AppComponent
import com.androidpoplib.githubconnect.di.DaggerAppComponent

import com.androidpoplib.githubconnect.di.module.AppModule
import com.androidpoplib.githubconnect.di.module.repository.RepositorySubcomponent
import com.androidpoplib.githubconnect.di.module.user.UserSubcomponent

class GithubApplication : Application() {

    companion object {
        lateinit var instance: GithubApplication
        const val DEBUG = true
    }

    lateinit var appComponent: AppComponent
    var userSubcomponent: UserSubcomponent? = null
        private set
    var repositorySubcomponent: RepositorySubcomponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initUserSubcomponent() = appComponent.userSubcomponent().also {
        userSubcomponent = it
    }

    fun releaseUserSubcomponent() {
        userSubcomponent = null
    }

    fun initRepositorySubcomponent() = userSubcomponent?.repositorySubcomponent().also {
        repositorySubcomponent = it
    }

    fun releaseRepositorySubcomponent() {
        repositorySubcomponent = null
    }
}