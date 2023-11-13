package com.animsh.runningtracker.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.animsh.runningtracker.db.Post
import com.animsh.runningtracker.other.SortsType
import com.animsh.runningtracker.repositories.PostRepository
import kotlinx.coroutines.launch

class PostViewModel @ViewModelInject constructor(
    val postRepository: PostRepository
) : ViewModel() {
    private val postGetAll = postRepository.getAllPosts()

    val posts = MediatorLiveData<List<Post>>()


    init {
        posts.addSource(postGetAll) { result ->

            result?.let {posts.value = it}
        }
    }

    fun insertPost(post: Post) = viewModelScope.launch {
        postRepository.insertPost(post)
    }

}
