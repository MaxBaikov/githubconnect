package com.androidpoplib.githubconnect.mvp.presenter

import com.androidpoplib.githubconnect.mvp.view.ForkView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ForkPresenter : MvpPresenter<ForkView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.release()
    }
}