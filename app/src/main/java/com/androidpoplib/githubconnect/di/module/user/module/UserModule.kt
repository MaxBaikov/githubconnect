package com.androidpoplib.githubconnect.di.module.user.module

import com.androidpoplib.githubconnect.di.module.user.UserScope
import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import com.androidpoplib.githubconnect.mvp.model.cache.IUsersCache
import com.androidpoplib.githubconnect.mvp.model.cache.room.RoomUsersCache
import com.androidpoplib.githubconnect.mvp.model.entity.room.Database
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUsers
import com.androidpoplib.githubconnect.mvp.model.repo.retrofit.RetrofitGithubUsers
import com.androidpoplib.githubconnect.ui.network.INetworkStatus
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun usersCache(database: Database):
            IUsersCache = RoomUsersCache(database)

    @UserScope
    @Provides
    fun usersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IUsersCache
    ): IGithubUsers = RetrofitGithubUsers(api, networkStatus, cache)

}