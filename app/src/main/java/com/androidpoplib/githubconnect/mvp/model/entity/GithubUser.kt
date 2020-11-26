package com.androidpoplib.githubconnect.mvp.model.entity

import com.google.gson.annotations.Expose

data class GithubUser(

    @Expose val login: String,
    @Expose val id: String? = null,
    @Expose val avatarUrl: String? = null,
    @Expose val reposUrl: String? = null

)
