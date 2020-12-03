package com.androidpoplib.githubconnect.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidpoplib.githubconnect.R
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUserRepo
import com.androidpoplib.githubconnect.mvp.presenter.ForkPresenter
import com.androidpoplib.githubconnect.mvp.view.ForkView
import com.androidpoplib.githubconnect.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_fork.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ForkFragment : MvpAppCompatFragment(), ForkView, BackButtonListener {

    companion object {
        lateinit var currentRepo: GithubUserRepo
        fun newInstance(repo: GithubUserRepo): ForkFragment {
            currentRepo = repo
            return ForkFragment()
        }
    }

    val presenter: ForkPresenter by moxyPresenter { ForkPresenter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_fork, null)


    override fun init() {
        repo_fork.text = currentRepo.forks.toString()
    }

    override fun backPressed() = presenter.backPressed()

}