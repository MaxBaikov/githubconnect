package com.androidpoplib.githubconnect.di.module

import com.androidpoplib.githubconnect.ui.GithubApplication
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

@Module
class AppModule(val app: GithubApplication) {

    @Provides
    fun app(): GithubApplication {
        return app
    }

    @Provides
    fun mainTreadScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
