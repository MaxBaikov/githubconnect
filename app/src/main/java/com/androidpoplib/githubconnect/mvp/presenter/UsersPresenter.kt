package com.androidpoplib.githubconnect.mvp.presenter

import android.util.Log
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUsers
import com.androidpoplib.githubconnect.mvp.presenter.list.IUserListPresenter
import com.androidpoplib.githubconnect.mvp.view.UserItemView
import com.androidpoplib.githubconnect.mvp.view.UsersView
import com.androidpoplib.githubconnect.navigation.Screens
import com.androidpoplib.githubconnect.ui.adapters.UsersRVAdapter
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class UsersPresenter : MvpPresenter<UsersView>() {

    @Inject lateinit var scheduler: Scheduler
    @Inject lateinit var router: Router
    @Inject lateinit var usersRepo: IGithubUsers

    companion object {
        const val TAG = "githubconnect"
    }

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size

        override fun bindView(view: UsersRVAdapter.ViewHolder) {
            val user = users[view.pos]
            user.login?.let { view.setLogin(it) }
            user.avatarUrl?.let { view.loadAvatar(it) }
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            router.navigateTo(
                Screens.ReposScreen(
                    usersListPresenter.users.elementAt(itemView.pos)
                )
            )
        }
    }

    private fun loadData() {
        usersRepo.getUsers()
            .observeOn(scheduler)
            .subscribe({
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(it)
                viewState.updateList()
            }) {
                Log.w(Companion.TAG, "Error" + it.localizedMessage)
            }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.release()
    }


}
