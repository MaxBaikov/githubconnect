package com.androidpoplib.githubconnect.mvp.model.entity.room.dao

import androidx.room.*
import com.androidpoplib.githubconnect.mvp.model.entity.room.RoomGithubUserRepo

@Dao
interface UserRepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGithubUserRepo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomGithubUserRepo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomGithubUserRepo>)

    @Update
    fun update(user: RoomGithubUserRepo)

    @Update
    fun update(vararg users: RoomGithubUserRepo)

    @Update
    fun update(users: List<RoomGithubUserRepo>)

    @Delete
    fun delete(user: RoomGithubUserRepo)

    @Delete
    fun delete(vararg users: RoomGithubUserRepo)

    @Delete
    fun delete(users: List<RoomGithubUserRepo>)

    @Query("SELECT * FROM RoomGithubUserRepo")
    fun getAll(): List<RoomGithubUserRepo>

    @Query("SELECT * FROM RoomGithubUserRepo WHERE userId = :userId")
    fun findForUser(userId: String): List<RoomGithubUserRepo>
}