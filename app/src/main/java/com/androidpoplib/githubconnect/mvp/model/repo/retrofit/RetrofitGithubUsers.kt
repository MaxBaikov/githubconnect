package com.androidpoplib.githubconnect.mvp.model.repo.retrofit

import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.entity.cache.IUsersCache
import com.androidpoplib.githubconnect.mvp.model.entity.room.Database
import com.androidpoplib.githubconnect.mvp.model.entity.room.RoomGithubUser
import com.androidpoplib.githubconnect.ui.network.INetworkStatus
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUsers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.Callable

class RetrofitGithubUsers(private val api: IDataSource,
                          private val networkStatus: INetworkStatus,
                          private val userCache: IUsersCache
): IGithubUsers {

    override fun getUsers(): Single<List<GithubUser>> = networkStatus.isOnlineSingle.flatMap(
        fun(isOnline: Boolean): SingleSource<out List<GithubUser>>? {
            return if (isOnline) api.getUsers()
                .flatMap(
                    fun(users: List<GithubUser>): SingleSource<out List<GithubUser>>? {
                        return userCache.getUsers().flatMap{
                            userCache.putUsers(users).toSingleDefault(it)
                        }

                    }
                ) else {
                return userCache.getUsers()

            }
        }
    ).subscribeOn(Schedulers.io())
}
