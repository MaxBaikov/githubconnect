package com.androidpoplib.githubconnect.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidpoplib.githubconnect.R
import com.androidpoplib.githubconnect.mvp.model.entity.room.Database
import com.androidpoplib.githubconnect.mvp.presenter.UsersPresenter
import com.androidpoplib.githubconnect.mvp.view.UsersView
import com.androidpoplib.githubconnect.ui.BackButtonListener
import com.androidpoplib.githubconnect.ui.adapters.UsersRVAdapter
import io.reactivex.rxjava3.core.Scheduler
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    @Inject
    lateinit var database: Database

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var scheduler: Scheduler

    companion object {
        fun newInstance() = UsersFragment()
    }


    val presenter: UsersPresenter by moxyPresenter { UsersPresenter() }

    var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View.inflate(context, R.layout.fragment_users, null)

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



