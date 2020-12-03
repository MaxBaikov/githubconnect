package com.androidpoplib.githubconnect.di.module

import androidx.room.Room
import com.androidpoplib.githubconnect.GithubApplication
import com.androidpoplib.githubconnect.mvp.model.cache.IRepoCache
import com.androidpoplib.githubconnect.mvp.model.cache.IUsersCache
import com.androidpoplib.githubconnect.mvp.model.cache.room.RoomRepoCache
import com.androidpoplib.githubconnect.mvp.model.cache.room.RoomUsersCache
import com.androidpoplib.githubconnect.mvp.model.entity.room.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: GithubApplication):
            Database = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()

    @Singleton
    @Provides
    fun usersCache(database: Database):
            IUsersCache = RoomUsersCache(database)

    @Singleton
    @Provides
    fun repoCache(database: Database):
            IRepoCache = RoomRepoCache(database)

}
