package com.androidpoplib.githubconnect.mvp.presenter


import android.util.Log
import com.androidpoplib.githubconnect.GithubApplication
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUser
import com.androidpoplib.githubconnect.mvp.model.entity.GithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.repo.IGithubUserRepo
import com.androidpoplib.githubconnect.mvp.model.repo.retrofit.RetrofitGithubUserRepo
import com.androidpoplib.githubconnect.mvp.view.RepoItemView
import com.androidpoplib.githubconnect.mvp.view.RepoView
import com.androidpoplib.githubconnect.navigation.Screens
import com.androidpoplib.githubconnect.ui.adapters.RepoRVAdapter
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class RepoPresenter(
    private val scheduler: Scheduler,
    private val router: Router?,
    private val usersRepo: IGithubUserRepo,
    private val user: GithubUser
) : MvpPresenter<RepoView>() {

    //    private val repoRepo = GithubApplication.instance.let {
//        RetrofitGithubUserRepo(it,user) }
    private val TAG = RepoPresenter::class.java.simpleName

    class RepoListPresenter : IRepoListPresenter {
        val repos = mutableListOf<GithubUserRepo>()
        override var itemClickListener: ((RepoItemView) -> Unit)? = null

        override fun getCount() = repos.size

        override fun bindView(view: RepoRVAdapter.ViewHolder) {
            val repo = repos[view.pos]
            repo.name?.let { view.setRepoName(it) }
        }
    }

    val repoListPresenter = RepoListPresenter()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        repoListPresenter.itemClickListener = { itemView ->
            router?.navigateTo(Screens.ForksScreen(repoListPresenter.repos.elementAt(itemView.pos)))
        }
    }

    private fun loadData() {
        usersRepo.getRepos(user)
            .observeOn(scheduler)
            .subscribe({ repos ->
                repoListPresenter.repos.clear()
                repoListPresenter.repos.addAll(repos)
                viewState.updateList()
            }) {
                    Log.w(TAG, "Error" + it.localizedMessage)
            }
    }

    fun backPressed(): Boolean {
        router?.exit()
        return true
    }
}