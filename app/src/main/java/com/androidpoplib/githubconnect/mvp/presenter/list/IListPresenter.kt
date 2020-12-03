package com.androidpoplib.githubconnect.mvp.presenter.list

import com.androidpoplib.githubconnect.mvp.view.ItemView

interface IListPresenter<V : ItemView> {
    var itemClickListener: ((V) -> Unit)?

    fun getCount(): Int
}
