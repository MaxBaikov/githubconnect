package com.androidpoplib.githubconnect.mvp.presenter

import com.androidpoplib.githubconnect.GithubApplication
import com.androidpoplib.githubconnect.mvp.view.MainView
import com.androidpoplib.githubconnect.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    init {
        GithubApplication.instance.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UsersScreen())
    }

    fun backClicked() {
        router.exit()
    }
}