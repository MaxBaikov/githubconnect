package com.androidpoplib.githubconnect.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidpoplib.githubconnect.ApiHolder
import com.androidpoplib.githubconnect.GithubApplication
import com.androidpoplib.githubconnect.R
import com.androidpoplib.githubconnect.mvp.model.entity.room.Database
import com.androidpoplib.githubconnect.mvp.model.entity.room.cache.RoomUsersCache
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUsers
import com.androidpoplib.githubconnect.mvp.model.repo.retrofit.RetrofitGithubUsers
import com.androidpoplib.githubconnect.mvp.presenter.UsersPresenter
import com.androidpoplib.githubconnect.mvp.view.UsersView
import com.androidpoplib.githubconnect.ui.BackButtonListener
import com.androidpoplib.githubconnect.ui.adapters.UsersRVAdapter
import com.androidpoplib.githubconnect.ui.network.AndroidNetworkStatus
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter(
        factory = fun(): UsersPresenter {
            val githubUsersRepo: IGithubUsers = RetrofitGithubUsers(
                ApiHolder.api,
                AndroidNetworkStatus(),
                userCache = RoomUsersCache(Database.getInstance(GithubApplication.instance)!!)
            )
            return UsersPresenter(
                AndroidSchedulers.mainThread(),
                GithubApplication.instance.router,
                githubUsersRepo

            )
        })

    var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        View.inflate(context, R.layout.fragment_users, null)

    override fun init() {
        rv_users.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        rv_users.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}



