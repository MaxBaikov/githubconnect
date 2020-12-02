package com.androidpoplib.githubconnect

import android.app.Application
import com.androidpoplib.githubconnect.mvp.model.entity.room.Database
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class GithubApplication : Application() {

    companion object {
        lateinit var instance: GithubApplication
        const val DEBUG = true
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Database.getInstance(this)

    }

    val navigatorHolder: NavigatorHolder
        get() = cicerone.navigatorHolder

    val router
        get() = cicerone.router

}