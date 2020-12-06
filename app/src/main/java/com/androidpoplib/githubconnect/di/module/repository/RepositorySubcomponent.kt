package com.androidpoplib.githubconnect.di.module.repository

import com.androidpoplib.githubconnect.di.module.repository.module.RepositoryModule
import com.androidpoplib.githubconnect.mvp.presenter.ForkPresenter
import com.androidpoplib.githubconnect.mvp.presenter.RepoPresenter
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        RepositoryModule::class
    ]
)
interface RepositorySubcomponent {

    fun inject(forkPresenter: ForkPresenter)
    fun inject(repoPresenter: RepoPresenter)
}