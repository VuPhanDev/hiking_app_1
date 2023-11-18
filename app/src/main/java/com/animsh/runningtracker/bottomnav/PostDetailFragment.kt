package com.animsh.runningtracker.bottomnav

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.animsh.runningtracker.R
import com.animsh.runningtracker.db.Post
import com.animsh.runningtracker.ui.viewmodels.PostViewModel
import com.bumptech.glide.Glide
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_post.*
import kotlinx.android.synthetic.main.fragment_post_detail.*
import kotlinx.android.synthetic.main.item_post.view.*
import java.io.IOException
import java.io.InputStream


@AndroidEntryPoint
class PostDetailFragment : Fragment(R.layout.fragment_post_detail) {

    private val viewModel: PostViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layout_back.setOnClickListener {
            requireActivity().onBackPressed()
        }
        val post = loadPost()
        Log.d("PostDetailFragment", "Selected Post: ${post?.description}")
            Glide.with(this)
                .load(post?.imagePath)
                .into(img_post)
            tv_content.text = post?.description

    }

    private val sharedPreferences by lazy {
        requireActivity().getPreferences(Context.MODE_PRIVATE)
    }

    private fun SharedPreferences.getPost(key: String): Post? {
        val gson = Gson()
        val postJson = getString(key, null)
        return gson.fromJson(postJson, Post::class.java)
    }

    private fun loadPost(): Post? {
        return sharedPreferences.getPost("postKey")
    }
}