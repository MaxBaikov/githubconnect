package com.androidpoplib.githubconnect.mvp.model.entity

import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import io.reactivex.rxjava3.core.Observable

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5"),
        GithubUser("login6"),
        GithubUser("login7"),
        GithubUser("login8"),
        GithubUser("login9")

    )

    fun getUsers(): Observable<GithubUser> {
        return Observable.fromIterable(repositories)
    }

}