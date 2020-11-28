package com.androidpoplib.githubconnect.mvp.presenter

import com.androidpoplib.githubconnect.mvp.view.IItemView
import com.androidpoplib.githubconnect.ui.adapters.UsersRVAdapter

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?

    fun getCount(): Int
}

