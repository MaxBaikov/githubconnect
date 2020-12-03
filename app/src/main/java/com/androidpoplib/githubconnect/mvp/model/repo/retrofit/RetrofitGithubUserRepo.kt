package com.androidpoplib.githubconnect.mvp.model.repo.retrofit

import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.cache.IRepoCache
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUserRepo
import com.androidpoplib.githubconnect.ui.network.INetworkStatus
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource
import io.reactivex.rxjava3.schedulers.Schedulers


class RetrofitGithubUserRepo(private val api: IDataSource,
                             private val networkStatus: INetworkStatus,
                             private val repositoriesCache: IRepoCache
) : IGithubUserRepo {

    override fun getRepos(user: GithubUser): Single<List<GithubUserRepo>> = networkStatus.isOnlineSingle.flatMap { isOnline ->
        if (isOnline) {
            user.login?.let(fun(login: String): @NonNull Single<List<GithubUserRepo>>? {
                return api.getUserRepo(login)
                    .flatMap(
                        fun(repositories: List<GithubUserRepo>): SingleSource<out List<GithubUserRepo>>? {
                            return repositoriesCache.putRepositories(user, repositories).toSingleDefault(repositories)
                        }
                    )
            }) ?: Single.error<List<GithubUserRepo>>(RuntimeException("User has no repos url"))
                .subscribeOn(Schedulers.io())
        } else {
            return@flatMap repositoriesCache.getRepositories(user)
        }
    }.subscribeOn(Schedulers.io())
}