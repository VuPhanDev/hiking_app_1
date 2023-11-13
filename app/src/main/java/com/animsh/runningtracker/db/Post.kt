package com.animsh.runningtracker.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
data class Post(
    var imagePath: Bitmap? = null,
    var description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}