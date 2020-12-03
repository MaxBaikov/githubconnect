package com.androidpoplib.githubconnect.mvp.model.cache

import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IRepoCache  {
    fun getRepositories(user: GithubUser): Single<List<GithubUserRepo>>
    fun putRepositories(user: GithubUser, repositories: List<GithubUserRepo>): Completable
}