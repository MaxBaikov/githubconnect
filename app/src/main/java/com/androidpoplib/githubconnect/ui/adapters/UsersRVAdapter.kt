package com.androidpoplib.githubconnect.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.androidpoplib.githubconnect.R
import com.androidpoplib.githubconnect.mvp.presenter.list.IUserListPresenter
import com.androidpoplib.githubconnect.mvp.view.UserItemView
import com.androidpoplib.githubconnect.mvp.view.image.IImageLoader
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.view.*
import javax.inject.Inject


class UsersRVAdapter(
    val presenter: IUserListPresenter,
    ) : RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    @Inject lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer, UserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(containerView) {
            user_login.text = text
        }

        override fun loadAvatar(url: String) {
            imageLoader.loadImage(url, containerView.iv_avatar)
        }

    }
}
