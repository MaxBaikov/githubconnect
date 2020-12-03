package com.androidpoplib.githubconnect.di

import com.androidpoplib.githubconnect.MainActivity
import com.androidpoplib.githubconnect.di.module.*
import com.androidpoplib.githubconnect.mvp.presenter.ForkPresenter
import com.androidpoplib.githubconnect.mvp.presenter.MainPresenter
import com.androidpoplib.githubconnect.mvp.presenter.RepoPresenter
import com.androidpoplib.githubconnect.mvp.presenter.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CacheModule::class,
        CiceroneModule::class,
        RepoModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(repoPresenter: RepoPresenter)
    fun inject(forkPresenter: ForkPresenter)
}



