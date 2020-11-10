package com.androidpoplib.githubconnect.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidpoplib.githubconnect.App
import com.androidpoplib.githubconnect.R
import com.androidpoplib.githubconnect.mvp.model.GithubUser
import com.androidpoplib.githubconnect.mvp.presenter.LoginPresenter
import com.androidpoplib.githubconnect.mvp.view.LoginView
import com.androidpoplib.githubconnect.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_login.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LoginFragment : MvpAppCompatFragment(), LoginView, BackButtonListener {

    companion object {
        lateinit var currentUser: GithubUser
        fun newInstance(user: GithubUser): LoginFragment {
            currentUser = user
            return LoginFragment()
        }
    }

    val presenter: LoginPresenter by moxyPresenter { LoginPresenter(App.instance.router) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_login, null)


    override fun init(){
        user_login.text = currentUser.login
    }

    override fun backPressed() = presenter.backPressed()

}