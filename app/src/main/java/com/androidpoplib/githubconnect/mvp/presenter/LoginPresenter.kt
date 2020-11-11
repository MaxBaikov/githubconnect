package com.androidpoplib.githubconnect.mvp.presenter


import com.androidpoplib.githubconnect.mvp.view.LoginView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class LoginPresenter(private val router: Router) : MvpPresenter<LoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}