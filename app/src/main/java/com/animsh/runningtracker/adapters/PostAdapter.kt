package com.animsh.runningtracker.adapters

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.animsh.runningtracker.R
import com.animsh.runningtracker.db.Post
import com.animsh.runningtracker.db.Run
import com.animsh.runningtracker.other.TrackingUtility
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_post.view.*
import kotlinx.android.synthetic.main.item_run.view.*
import java.text.SimpleDateFormat
import java.util.*

class PostAdapter(private val itemClickListener: OnItemClickListener) :RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class PostViewHolder(itemViewHolder: View) : RecyclerView.ViewHolder(itemViewHolder)

    val diffCallBack = object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(list: List<Post>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_post,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = differ.currentList[position]
        holder.itemView.apply {
            if (post.imagePath != null) {
                Glide.with(this)
                    .load(post.imagePath)
                    .into(img_post)
            }
            val description = post.description
            tv_description.text = description

            setOnClickListener {
                itemClickListener.onItemClick(post)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(post: Post)
    }
}