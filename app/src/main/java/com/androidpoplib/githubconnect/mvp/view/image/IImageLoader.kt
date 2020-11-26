package com.androidpoplib.githubconnect.mvp.view.image

interface IImageLoader<T> {
    fun loadImage(url: String?, container: T)
}