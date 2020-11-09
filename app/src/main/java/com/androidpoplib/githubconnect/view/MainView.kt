package com.androidpoplib.githubconnect.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {

    fun setTextBtn1(text: String)
    fun setTextBtn2(text: String)
    fun setTextBtn3(text: String)

}
