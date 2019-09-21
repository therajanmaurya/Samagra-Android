package com.example.samagra.android.api

import com.example.samagra.android.models.Comment
import com.example.samagra.android.models.Photo
import com.example.samagra.android.models.Post
import com.example.samagra.android.models.Todo
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("comments")
    fun getComments(): Observable<List<Comment>>

    @GET("photos")
    fun getPhotos(): Observable<List<Photo>>

    @GET("todos")
    fun getTodos(): Observable<List<Todo>>

    @GET("posts")
    fun getPosts(): Observable<List<Post>>
}
