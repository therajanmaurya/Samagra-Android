package com.example.samagra.android.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.samagra.android.models.Post
import io.reactivex.Completable

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(objs: List<Post>): Completable
}
