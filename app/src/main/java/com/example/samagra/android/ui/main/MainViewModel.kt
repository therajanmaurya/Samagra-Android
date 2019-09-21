package com.example.samagra.android.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samagra.android.models.ProcessTime
import com.example.samagra.android.repository.RepoRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val repoRepository: RepoRepository
) : ViewModel() {

    var commentsProcessTime: MutableLiveData<ProcessTime> = MutableLiveData()
    var postsProcessTime: MutableLiveData<ProcessTime> = MutableLiveData()
    var photosProcessTime: MutableLiveData<ProcessTime> = MutableLiveData()
    var todosProcessTime: MutableLiveData<ProcessTime> = MutableLiveData()

    fun fetchComments(isDelay: Boolean) {
        repoRepository.fetchComments()
            .delay(5, TimeUnit.SECONDS, isDelay)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<ProcessTime>() {
                override fun onComplete() {
                }

                override fun onNext(it: ProcessTime) {
                    commentsProcessTime.postValue(it)
                }

                override fun onError(e: Throwable) {
                    Log.d("Start Fetch Time", "Failed to Fetch")
                }
            })
    }

    fun fetchTodos(isDelay: Boolean) {
        repoRepository.fetchTodos()
            .delay(5, TimeUnit.SECONDS, isDelay)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<ProcessTime>() {
                override fun onComplete() {
                }

                override fun onNext(it: ProcessTime) {
                    todosProcessTime.postValue(it)
                }

                override fun onError(e: Throwable) {
                    Log.d("Start Fetch Time", "Failed to Fetch")
                }
            })
    }

    fun fetchPosts(isDelay: Boolean) {
        repoRepository.fetchPosts()
            .delay(5, TimeUnit.SECONDS, isDelay)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<ProcessTime>() {
                override fun onComplete() {
                }

                override fun onNext(it: ProcessTime) {
                    postsProcessTime.postValue(it)
                }

                override fun onError(e: Throwable) {
                    Log.d("Start Fetch Time", "Failed to Fetch")
                }
            })
    }

    fun fetchPhotos(isDelay: Boolean) {
        repoRepository.fetchPhotos()
            .delay(5, TimeUnit.SECONDS, isDelay)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<ProcessTime>() {
                override fun onComplete() {
                }

                override fun onNext(it: ProcessTime) {
                    photosProcessTime.postValue(it)
                }

                override fun onError(e: Throwable) {
                    Log.d("Start Fetch Time", "Failed to Fetch")
                }
            })
    }
}
