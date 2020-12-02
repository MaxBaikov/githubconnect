package com.androidpoplib.githubconnect.mvp.model.repo

import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Single

interface IGithubUserRepo {
    fun getRepos(user: GithubUser): Single<List<GithubUserRepo>>
}