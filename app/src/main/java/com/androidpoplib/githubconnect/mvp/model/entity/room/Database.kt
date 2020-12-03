package com.androidpoplib.githubconnect.mvp.model.entity.room

import androidx.room.RoomDatabase
import com.androidpoplib.githubconnect.mvp.model.entity.room.dao.RoomGithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.entity.room.dao.UserDao
import com.androidpoplib.githubconnect.mvp.model.entity.room.dao.UserRepoDao

@androidx.room.Database(entities = [RoomGithubUser::class, RoomGithubUserRepo::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract val userDao: UserDao
    abstract val repositoryDao: UserRepoDao

    companion object {
        const val DB_NAME = "database.db"
    }
}
