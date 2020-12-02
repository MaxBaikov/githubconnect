package com.androidpoplib.githubconnect.mvp.model.entity.room

import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidpoplib.githubconnect.GithubApplication
import com.androidpoplib.githubconnect.mvp.model.entity.room.dao.UserDao
import com.androidpoplib.githubconnect.mvp.model.entity.room.dao.UserRepoDao

@androidx.room.Database(entities = [RoomGithubUser::class, RoomGithubUserRepo::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repositoryDao: UserRepoDao

    companion object {
        private const val DB_NAME = "database.db"

        @Volatile
        private var instance: Database? = null

        fun getInstance(context: GithubApplication): Database? {
            var reflocal = instance
            if (reflocal == null) {
                synchronized(Database::class.java) {
                    instance = reflocal
                    if (reflocal == null) {
                        reflocal = Room.databaseBuilder(
                            context, Database::class.java, DB_NAME
                        ).build()
                    }
                    instance = reflocal
                }
            }
            return reflocal
        }
    }
}
