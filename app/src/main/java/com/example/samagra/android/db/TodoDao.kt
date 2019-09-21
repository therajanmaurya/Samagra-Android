package com.example.samagra.android.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.samagra.android.models.Todo
import io.reactivex.Completable

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(objs: List<Todo>): Completable
}
