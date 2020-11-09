package com.androidpoplib.githubconnect

import android.os.Bundle
import com.androidpoplib.githubconnect.model.CountersModel
import com.androidpoplib.githubconnect.presenter.MainPresenter
import com.androidpoplib.githubconnect.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val presenter by moxyPresenter {
        MainPresenter(CountersModel())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_counter1.setOnClickListener { presenter.clickBtn1() }
        btn_counter2.setOnClickListener { presenter.clickBtn2() }
        btn_counter3.setOnClickListener { presenter.clickBtn3() }
    }

    override fun setTextBtn1(text: String) {
        btn_counter1.text = text
    }

    override fun setTextBtn2(text: String) {
        btn_counter2.text = text
    }

    override fun setTextBtn3(text: String) {
        btn_counter3.text = text
    }

}

