package com.animsh.runningtracker.bottomnav

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.animsh.runningtracker.R
import com.animsh.runningtracker.adapters.PostAdapter
import com.animsh.runningtracker.db.Post
import com.animsh.runningtracker.ui.viewmodels.PostViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), PostAdapter.OnItemClickListener {

    private val viewModel: PostViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        btn_home_post.setOnClickListener{
            findNavController().navigate(R.id.action_menu_home_to_postFragment)
        }

        viewModel.posts.observe(viewLifecycleOwner, Observer {
            postAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() = rvPost.apply {
        postAdapter = PostAdapter(this@HomeFragment)
        adapter = postAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onItemClick(post: Post) {
        Log.d("aaaaa1", post.description)
        savePost(post)
        findNavController().navigate(R.id.action_menu_home_to_postDetailFragment)
    }

    private val sharedPreferences by lazy {
        requireActivity().getPreferences(Context.MODE_PRIVATE)
    }

    // Hàm extension để lưu đối tượng Post
    private fun SharedPreferences.Editor.putPost(key: String, post: Post) {
        val gson = Gson()
        val postJson = gson.toJson(post)
        putString(key, postJson)
    }

    private fun savePost(post: Post) {
        val editor = sharedPreferences.edit()
        editor.putPost("postKey", post)
        editor.apply()
    }

}