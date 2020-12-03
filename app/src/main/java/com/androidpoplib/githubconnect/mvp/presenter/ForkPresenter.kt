package com.androidpoplib.githubconnect.mvp.presenter

import com.androidpoplib.githubconnect.GithubApplication
import com.androidpoplib.githubconnect.mvp.view.ForkView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ForkPresenter : MvpPresenter<ForkView>() {

    @Inject
    lateinit var router: Router

    init {
        GithubApplication.instance.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}