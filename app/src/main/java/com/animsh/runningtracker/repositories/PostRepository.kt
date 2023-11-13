package com.animsh.runningtracker.repositories

import com.animsh.runningtracker.db.Post
import com.animsh.runningtracker.db.PostDAO
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postDAO: PostDAO
) {

    suspend fun insertPost(post: Post) = postDAO.insertPost(post)

    suspend fun deletePost(post: Post) {
        postDAO.deletePost(post)
    }

    fun getAllPosts() = postDAO.getAllPosts()

    fun getAllPostsByDescription(searchQuery: String) = postDAO.getAllPostsByDescription(searchQuery)
}