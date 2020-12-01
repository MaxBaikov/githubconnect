package com.androidpoplib.githubconnect.mvp.model.entity.room.cache

import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.entity.cache.IRepoCache
import com.androidpoplib.githubconnect.mvp.model.entity.room.Database
import com.androidpoplib.githubconnect.mvp.model.entity.room.RoomGithubUser
import com.androidpoplib.githubconnect.mvp.model.entity.room.RoomGithubUserRepo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomRepoCache(private val db: Database) : IRepoCache {
    override fun getRepositories(user: GithubUser): Single<List<GithubUserRepo>> {
        return Single.fromCallable {
            val roomUser: RoomGithubUser = user.login?.let { db.userDao.findByLogin(it) }
                ?: throw RuntimeException("No such user in cache")

            val roomGithubRepository: List<RoomGithubUserRepo> =
                db.repositoryDao.findForUser(roomUser.id)

            val githubRepository: MutableList<GithubUserRepo> = ArrayList()

            roomGithubRepository.forEach {
                githubRepository.add(GithubUserRepo(it.id, it.name, it.forks))
            }

            githubRepository
        }
    }

    override fun putRepositories(
        user: GithubUser,
        repositories: List<GithubUserRepo>
    ): Completable {
        return Completable.fromAction {
            val roomUser: RoomGithubUser = user.login?.let { db.userDao.findByLogin(it) }
                ?: throw RuntimeException("No such user in cache")

            val roomGithubRepositories: MutableList<RoomGithubUserRepo> = ArrayList()

            repositories.forEach {
                roomGithubRepositories.add(
                    RoomGithubUserRepo(
                        it.id ?: "",
                        it.name ?: "",
                        it.forks ?: "0",
                        roomUser.id
                    )
                )
            }

            db.repositoryDao.insert(roomGithubRepositories)
        }.subscribeOn(Schedulers.io())
    }
}