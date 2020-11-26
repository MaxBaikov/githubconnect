package com.androidpoplib.githubconnect.mvp.model.repo.retrofit

import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUsersRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(private val api: IDataSource) : IGithubUsersRepo {
    override val users: Single<List<GithubUser>>
        get() = api.getUsers()?.subscribeOn(Schedulers.io())

}