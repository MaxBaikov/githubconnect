package com.androidpoplib.githubconnect.mvp.presenter

import com.androidpoplib.githubconnect.mvp.view.ForkView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class ForkPresenter(
    private val scheduler: Scheduler,
    private val router: Router?

) :
    MvpPresenter<ForkView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        router?.exit()
        return true
    }
}