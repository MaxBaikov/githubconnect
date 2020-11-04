package com.androidpoplib.githubconnect.presenter

import com.androidpoplib.githubconnect.model.CountersModel
import com.androidpoplib.githubconnect.view.MainView

const val INDEX_BTN_1 = 0
const val INDEX_BTN_2 = 1
const val INDEX_BTN_3 = 2

class MainPresenter(private val view: MainView) {
    private val model = CountersModel()

    fun clickBtn1() {
        view.setTextBtn1(model.next(INDEX_BTN_1).toString())
    }

    fun clickBtn2() {
        view.setTextBtn2(model.next(INDEX_BTN_2).toString())
    }

    fun clickBtn3() {
        view.setTextBtn3(model.next(INDEX_BTN_3).toString())
    }

}