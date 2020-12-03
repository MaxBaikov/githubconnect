package com.androidpoplib.githubconnect.di.module

import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import com.androidpoplib.githubconnect.mvp.model.cache.IRepoCache
import com.androidpoplib.githubconnect.mvp.model.cache.IUsersCache
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUsers
import com.androidpoplib.githubconnect.mvp.model.repo.retrofit.RetrofitGithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.repo.retrofit.RetrofitGithubUsers
import com.androidpoplib.githubconnect.ui.network.INetworkStatus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IUsersCache
    ): IGithubUsers = RetrofitGithubUsers(api, networkStatus, cache)

    @Singleton
    @Provides
    fun usersRepositories(
        api: IDataSource,
        networkStatus: INetworkStatus,
        repositoriesCache: IRepoCache
    ): IGithubUserRepo = RetrofitGithubUserRepo(api, networkStatus, repositoriesCache)

}

