package com.androidpoplib.githubconnect.di.module

import android.widget.ImageView
import com.androidpoplib.githubconnect.mvp.view.image.GlideImageLoader
import com.androidpoplib.githubconnect.mvp.view.image.IImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ImageModule {

    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()

}