package com.androidpoplib.githubconnect.mvp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser (
    val login: String
) : Parcelable