package com.androidpoplib.githubconnect.navigation

import com.androidpoplib.githubconnect.mvp.model.entity.GitHubUserRepo
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.ui.fragments.ForkFragment
import com.androidpoplib.githubconnect.ui.fragments.RepoFragment
import com.androidpoplib.githubconnect.ui.fragments.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen() : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }
    class ReposScreen(private val user: GithubUser) : SupportAppScreen() {
        override fun getFragment() = RepoFragment.newInstance(user)
    }
    class ForksScreen(private val repo: GitHubUserRepo) : SupportAppScreen() {
        override fun getFragment() = ForkFragment.newInstance(repo)
    }

}
