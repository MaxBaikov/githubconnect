package com.androidpoplib.githubconnect.di.module.user

import com.androidpoplib.githubconnect.di.module.repository.RepositorySubcomponent
import com.androidpoplib.githubconnect.di.module.user.module.UserModule
import com.androidpoplib.githubconnect.mvp.presenter.UsersPresenter
import dagger.Subcomponent

@UserScope
@Subcomponent(
    modules = [
        UserModule::class
    ]
)
interface UserSubcomponent {
    fun repositorySubcomponent(): RepositorySubcomponent

    fun inject(usersPresenter: UsersPresenter)
}