package com.androidpoplib.githubconnect.di.module

import androidx.room.Room
import com.androidpoplib.githubconnect.ui.GithubApplication
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

}
