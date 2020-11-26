package com.androidpoplib.githubconnect.mvp.presenter


import com.androidpoplib.githubconnect.navigation.Screens
import com.androidpoplib.githubconnect.mvp.view.MainView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(private val router: Router?) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router?.replaceScreen(Screens.UsersScreen())
    }

    fun backClicked() {
        router?.exit()
    }
}

