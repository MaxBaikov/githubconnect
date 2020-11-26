package com.androidpoplib.githubconnect.mvp.view



interface UserItemView : IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}

