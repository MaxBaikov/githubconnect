package com.androidpoplib.githubconnect.mvp.model.repo

import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsers {
    fun getUsers(): Single<List<GithubUser>>
}