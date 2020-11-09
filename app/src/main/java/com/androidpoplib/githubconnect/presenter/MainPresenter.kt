package com.androidpoplib.githubconnect.presenter

import com.androidpoplib.githubconnect.model.CountersModel
import com.androidpoplib.githubconnect.view.MainView
import moxy.MvpPresenter

const val INDEX_BTN_1 = 0
const val INDEX_BTN_2 = 1
const val INDEX_BTN_3 = 2

class MainPresenter(val model: CountersModel): MvpPresenter<MainView>() {
//    private val model = CountersModel()

    fun clickBtn1() {
        viewState.setTextBtn1(model.next(INDEX_BTN_1).toString())
    }

    fun clickBtn2() {
        viewState.setTextBtn2(model.next(INDEX_BTN_2).toString())
    }

    fun clickBtn3() {
        viewState.setTextBtn3(model.next(INDEX_BTN_3).toString())
    }

}