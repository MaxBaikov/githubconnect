package com.androidpoplib.githubconnect.mvp.model.repo

import com.androidpoplib.githubconnect.mvp.model.entity.GitHubUserRepo
import io.reactivex.rxjava3.core.Single

interface IGithubUserRepo {
    val userRepo: Single<List<GitHubUserRepo>>
}