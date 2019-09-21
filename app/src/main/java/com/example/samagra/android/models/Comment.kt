package com.example.samagra.android.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comments")
data class Comment(

    @PrimaryKey
    @field:SerializedName("id")
    var id: Int = 0,

    @field:SerializedName("postId")
    var postId: String = "",

    @field:SerializedName("name")
    var name: String = "",

    @field:SerializedName("email")
    var email: String = "",

    @field:SerializedName("body")
    var body: String = ""
)