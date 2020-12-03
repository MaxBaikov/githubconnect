package com.androidpoplib.githubconnect.mvp.model.entity.room.dao

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.androidpoplib.githubconnect.mvp.model.entity.room.RoomGithubUser
import org.jetbrains.annotations.NotNull


@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomGithubUser::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)

class RoomGithubUserRepo(
    @PrimaryKey @NotNull var id: String,
    var name: String,
    var forks: String,
    var userId: String
)


