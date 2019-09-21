package com.example.samagra.android.repository

import com.example.samagra.android.AppExecutors
import com.example.samagra.android.api.RetrofitService
import com.example.samagra.android.db.CommentDao
import com.example.samagra.android.db.PhotoDao
import com.example.samagra.android.db.PostDao
import com.example.samagra.android.db.TodoDao
import com.example.samagra.android.models.ProcessTime
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val retrofitService: RetrofitService,
    private val commentDao: CommentDao,
    private val todoDao: TodoDao,
    private val photoDao: PhotoDao,
    private val postDao: PostDao
) {

    fun fetchComments(): Observable<ProcessTime> {
        val processTime = ProcessTime()
        return retrofitService.getComments()
            .concatMap { comments ->
                processTime.endFetchTime = System.currentTimeMillis() / 1000
                appExecutors.diskIO().execute {
                    processTime.startSaveTime = System.currentTimeMillis() / 1000
                    commentDao.insert(comments)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                }
                return@concatMap Observable.just(processTime)
            }
            .concatMap {
                it.endSaveTime = System.currentTimeMillis() / 1000
                return@concatMap Observable.just(it)
            }
    }

    fun fetchPosts(): Observable<ProcessTime> {
        val processTime = ProcessTime()
        return retrofitService.getPosts()
            .concatMap { comments ->
                processTime.endFetchTime = System.currentTimeMillis() / 1000
                appExecutors.diskIO().execute {
                    processTime.startSaveTime = System.currentTimeMillis() / 1000
                    postDao.insert(comments)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                }
                return@concatMap Observable.just(processTime)
            }
            .concatMap {
                it.endSaveTime = System.currentTimeMillis() / 1000
                return@concatMap Observable.just(it)
            }
    }

    fun fetchTodos(): Observable<ProcessTime> {
        val processTime = ProcessTime()
        return retrofitService.getTodos()
            .concatMap { comments ->
                processTime.endFetchTime = System.currentTimeMillis() / 1000
                appExecutors.diskIO().execute {
                    processTime.startSaveTime = System.currentTimeMillis() / 1000
                    todoDao.insert(comments)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                }
                return@concatMap Observable.just(processTime)
            }
            .concatMap {
                it.endSaveTime = System.currentTimeMillis() / 1000
                return@concatMap Observable.just(it)
            }
    }

    fun fetchPhotos(): Observable<ProcessTime> {
        val processTime = ProcessTime()
        return retrofitService.getPhotos()
            .concatMap { comments ->
                processTime.endFetchTime = System.currentTimeMillis() / 1000
                appExecutors.diskIO().execute {
                    processTime.startSaveTime = System.currentTimeMillis() / 1000
                    photoDao.insert(comments)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                }
                return@concatMap Observable.just(processTime)
            }
            .concatMap {
                it.endSaveTime = System.currentTimeMillis() / 1000
                return@concatMap Observable.just(it)
            }
    }
}
