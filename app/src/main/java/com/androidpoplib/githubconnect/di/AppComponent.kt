package com.androidpoplib.githubconnect.di

import com.androidpoplib.githubconnect.di.module.*
import com.androidpoplib.githubconnect.di.module.user.UserSubcomponent
import com.androidpoplib.githubconnect.mvp.presenter.MainPresenter
import com.androidpoplib.githubconnect.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CacheModule::class,
        CiceroneModule::class,
        ImageModule::class,
    ]
)

interface AppComponent {
    fun userSubcomponent(): UserSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)


}



