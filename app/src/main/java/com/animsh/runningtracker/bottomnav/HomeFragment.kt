package com.animsh.runningtracker.bottomnav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.animsh.runningtracker.R
import com.animsh.runningtracker.adapters.PostAdapter
import com.animsh.runningtracker.ui.viewmodels.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

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
        postAdapter = PostAdapter()
        adapter = postAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}