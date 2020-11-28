package com.androidpoplib.githubconnect.mvp.presenter

import com.androidpoplib.githubconnect.mvp.view.RepoItemView
import com.androidpoplib.githubconnect.ui.adapters.RepoRVAdapter

interface IRepoListPresenter : IListPresenter<RepoItemView>{
    fun bindView(view: RepoRVAdapter.ViewHolder)
}