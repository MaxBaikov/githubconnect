package com.androidpoplib.githubconnect.mvp.model.api

import com.androidpoplib.githubconnect.mvp.model.entity.GithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {

    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>

    @GET("/users/{login}/repos")
    fun getUserRepo (@Path("login") login: String): Single<List<GithubUserRepo>>
}