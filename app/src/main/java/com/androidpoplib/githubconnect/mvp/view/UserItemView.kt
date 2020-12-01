package com.androidpoplib.githubconnect.mvp.view



interface UserItemView : ItemView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}

