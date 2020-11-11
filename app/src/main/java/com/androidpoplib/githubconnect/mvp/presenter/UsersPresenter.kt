package com.androidpoplib.githubconnect.mvp.presenter

import com.androidpoplib.githubconnect.mvp.model.GithubUser
import com.androidpoplib.githubconnect.mvp.model.GithubUsersRepo
import com.androidpoplib.githubconnect.mvp.view.UserItemView
import com.androidpoplib.githubconnect.mvp.view.UsersView
import com.androidpoplib.githubconnect.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(private val usersRepo: GithubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {
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

        usersListPresenter.itemClickListener = { itemView ->
            usersRepo.fromIterable().elementAt(itemView.pos.toLong()).subscribe { s ->
                router.navigateTo(Screens.LoginScreen(s))
            }
        }
    }

    private fun loadData() {
        usersRepo.fromIterable().subscribe { s -> usersListPresenter.users.add(s) }
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}
