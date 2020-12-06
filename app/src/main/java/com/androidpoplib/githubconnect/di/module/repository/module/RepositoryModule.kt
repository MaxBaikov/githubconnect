package com.androidpoplib.githubconnect.di.module.repository.module

import com.androidpoplib.githubconnect.di.module.repository.RepositoryScope
import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import com.androidpoplib.githubconnect.mvp.model.cache.IRepoCache
import com.androidpoplib.githubconnect.mvp.model.cache.room.RoomRepoCache
import com.androidpoplib.githubconnect.mvp.model.entity.room.Database
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.repo.retrofit.RetrofitGithubUserRepo
import com.androidpoplib.githubconnect.ui.network.INetworkStatus
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {
    @Provides
    fun repoCache(database: Database):
            IRepoCache = RoomRepoCache(database)


    @RepositoryScope
    @Provides
    fun usersRepositories(
        api: IDataSource,
        networkStatus: INetworkStatus,
        repositoriesCache: IRepoCache
    ): IGithubUserRepo = RetrofitGithubUserRepo(api, networkStatus, repositoriesCache)


}