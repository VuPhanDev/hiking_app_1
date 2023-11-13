package com.animsh.runningtracker.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: Post)

    @Delete
    suspend fun deletePost(post: Post)

    @Query("SELECT * FROM post_table ORDER BY id DESC")
    fun getAllPosts(): LiveData<List<Post>>

    @Query("SELECT * FROM post_table WHERE description LIKE '%' || :searchQuery || '%' ORDER BY id DESC")
    fun getAllPostsByDescription(searchQuery: String): LiveData<List<Post>>
}