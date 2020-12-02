package com.androidpoplib.githubconnect.mvp.presenter.list

import com.androidpoplib.githubconnect.mvp.view.UserItemView
import com.androidpoplib.githubconnect.ui.adapters.UsersRVAdapter

interface IUserListPresenter : IListPresenter<UserItemView> {
    fun bindView(view: UsersRVAdapter.ViewHolder)
}
