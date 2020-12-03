package com.androidpoplib.githubconnect.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidpoplib.githubconnect.R
import com.androidpoplib.githubconnect.mvp.presenter.list.IRepoListPresenter
import com.androidpoplib.githubconnect.mvp.view.RepoItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repo.view.*


class RepoRVAdapter(
    val presenter: IRepoListPresenter,
) : RecyclerView.Adapter<RepoRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        )

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer, RepoItemView {
        override var pos = -1

        override fun setRepoName(text: String) = with(containerView) {
            user_repo.text = text
        }

    }

}

