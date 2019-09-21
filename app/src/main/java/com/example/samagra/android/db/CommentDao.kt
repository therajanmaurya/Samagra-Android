package com.example.samagra.android.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.samagra.android.models.Comment
import io.reactivex.Completable

@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: Comment): Completable


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(objs: List<Comment>): Completable
}
