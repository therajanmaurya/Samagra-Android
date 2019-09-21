package com.example.samagra.android.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.samagra.android.models.Comment
import com.example.samagra.android.models.Photo
import com.example.samagra.android.models.Post
import com.example.samagra.android.models.Todo

/**
 * Main database description.
 */
@Database(
    entities = [Post::class, Comment::class, Photo::class, Todo::class],
    version = 1,
    exportSchema = false
)
abstract class SamagraDb : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    abstract fun postDao(): PostDao

    abstract fun todoDao(): TodoDao

    abstract fun commentDao(): CommentDao
}