package com.androidpoplib.githubconnect.mvp.presenter

import android.util.Log
import com.androidpoplib.githubconnect.GithubApplication
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.repo.retrofit.RetrofitGithubUsersRepo
import com.androidpoplib.githubconnect.mvp.view.UserItemView
import com.androidpoplib.githubconnect.mvp.view.UsersView
import com.androidpoplib.githubconnect.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(
    private val scheduler: Scheduler,
    private val router: Router?
) :
    MvpPresenter<UsersView>() {

    private val usersRepo = GithubApplication.application?.api?.let { RetrofitGithubUsersRepo(it) }
    private val TAG = UsersPresenter::class.java.simpleName

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
            router?.navigateTo(Screens.LoginScreen(usersListPresenter.users.elementAt(itemView.pos)))
        }
    }

    private fun loadData() {
        usersRepo?.users?.observeOn(scheduler)?.subscribe({ repos ->
            usersListPresenter.users.clear()
            usersListPresenter.users.addAll(repos)
            viewState.updateList()
        }) { e -> Log.w(TAG, "Error" + e.localizedMessage) }
    }


    fun backPressed(): Boolean {
        router?.exit()
        return true
    }

}
