package com.androidpoplib.githubconnect

import android.app.Application
import com.androidpoplib.githubconnect.di.AppComponent
import com.androidpoplib.githubconnect.di.DaggerAppComponent
import com.androidpoplib.githubconnect.di.module.AppModule

class GithubApplication : Application() {

    companion object {
        lateinit var instance: GithubApplication
        const val DEBUG = true
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}