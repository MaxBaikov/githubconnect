package com.androidpoplib.githubconnect

import android.app.Application
import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class GithubApplication : Application() {

    private var cicerone: Cicerone<Router>? = null
    private var apiHolder: ApiHolder? = null

    override fun onCreate() {
        super.onCreate()
        application = this
        initCicerone()
        apiHolder = ApiHolder()
    }

    private fun initCicerone() {
        cicerone = Cicerone.create()
    }

    val router
        get() = cicerone?.router

    val navigatorHolder: NavigatorHolder?
        get() = cicerone?.navigatorHolder

    val api: IDataSource?
        get() = apiHolder?.getDataSource()

    companion object {
        var application: GithubApplication? = null
    }
}