package com.androidpoplib.githubconnect.mvp.presenter

import com.androidpoplib.githubconnect.mvp.model.GithubUser
import com.androidpoplib.githubconnect.mvp.model.GithubUsersRepo
import com.androidpoplib.githubconnect.mvp.view.UserItemView
import com.androidpoplib.githubconnect.mvp.view.UsersView
import com.androidpoplib.githubconnect.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) : MvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView -> router.navigateTo(Screens.LoginScreen(usersListPresenter.users[itemView.pos]))
        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}
