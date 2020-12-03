package com.androidpoplib.githubconnect.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidpoplib.githubconnect.R
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.presenter.RepoPresenter
import com.androidpoplib.githubconnect.mvp.view.RepoView
import com.androidpoplib.githubconnect.ui.BackButtonListener
import com.androidpoplib.githubconnect.ui.adapters.RepoRVAdapter
import kotlinx.android.synthetic.main.fragment_repo.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepoFragment : MvpAppCompatFragment(), RepoView, BackButtonListener {

    companion object {
        lateinit var currentUser: GithubUser

        fun newInstance(user: GithubUser): RepoFragment {
            currentUser = user
            return RepoFragment()
        }
    }

    val presenter: RepoPresenter by moxyPresenter { RepoPresenter(currentUser) }

    var adapter: RepoRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        View.inflate(context, R.layout.fragment_repo, null)


    override fun init() {
        rv_repos.layoutManager = LinearLayoutManager(context)
        adapter = RepoRVAdapter(presenter.repoListPresenter)
        rv_repos.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

}