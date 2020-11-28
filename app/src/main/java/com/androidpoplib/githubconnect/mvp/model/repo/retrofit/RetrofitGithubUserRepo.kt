package com.androidpoplib.githubconnect.mvp.model.repo.retrofit

import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import com.androidpoplib.githubconnect.mvp.model.entity.GitHubUserRepo
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUserRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class RetrofitGithubUserRepo(private val api: IDataSource,
    private val login: String
) : IGithubUserRepo {
    override val userRepo: Single<List<GitHubUserRepo>>
        get() = api.getUserRepo(login).subscribeOn(Schedulers.io())

}