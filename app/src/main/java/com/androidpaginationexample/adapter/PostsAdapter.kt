package com.androidpaginationexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidpaginationexample.data.Post
import com.androidpaginationexample.databinding.EachRowBinding

class PostsAdapter(
    val mContext: Context,
    val onPostClick: (Int, Post) -> Unit
) : PagingDataAdapter<Post, PostsAdapter.PostsViewHolder>(DiffUtils) {

    class PostsViewHolder(private val binding: EachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(posts: Post, onPostClick: (Int, Post) -> Unit) {
            binding.apply {

                txtId.text = "Id = ${posts.id}"
                txtTitle.text = "Title = ${posts.title}"
                txtBody.text = "Body = ${posts.body}"

                root.setOnClickListener {
                    onPostClick(bindingAdapterPosition, posts)
                }
            }
        }
    }

    object DiffUtils : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = getItem(position)
        if (post != null) {
            holder.bind(post,onPostClick)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            EachRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}