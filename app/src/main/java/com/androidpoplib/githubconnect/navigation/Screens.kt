package com.androidpoplib.githubconnect.navigation

import com.androidpoplib.githubconnect.mvp.model.GithubUser
import com.androidpoplib.githubconnect.ui.fragments.LoginFragment
import com.androidpoplib.githubconnect.ui.fragments.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen() : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }
    class LoginScreen(val user: GithubUser) : SupportAppScreen() {
        override fun getFragment() = LoginFragment.newInstance(user)
    }
}
