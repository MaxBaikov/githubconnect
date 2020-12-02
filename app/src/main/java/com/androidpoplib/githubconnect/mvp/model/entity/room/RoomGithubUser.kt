package com.androidpoplib.githubconnect.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class RoomGithubUser(
    @PrimaryKey @NotNull var id: String,
    var login: String,
    var avatarUrl: String,
    var reposUrl: String
)
