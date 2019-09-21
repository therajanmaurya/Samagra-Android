package com.example.samagra.android.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.samagra.android.AppExecutors
import com.example.samagra.android.api.BaseUrl
import com.example.samagra.android.api.RetrofitService
import com.example.samagra.android.db.*
import com.example.samagra.android.repository.RepoRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module(includes = [ViewModelModule::class])
open class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideApiGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): RetrofitService {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return Retrofit.Builder()
            .baseUrl(BaseUrl.defaultBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient.build())
            .build()
            .create(RetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(
        appExecutors: AppExecutors,
        retrofitService: RetrofitService,
        commentDao: CommentDao,
        postDao: PostDao,
        todoDao: TodoDao,
        photoDao: PhotoDao
    ): RepoRepository =
        RepoRepository(appExecutors, retrofitService, commentDao, todoDao, photoDao, postDao)

    @Singleton
    @Provides
    fun provideDb(app: Application): SamagraDb {
        return Room
            .databaseBuilder(app, SamagraDb::class.java, "samagra.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePostDao(db: SamagraDb): PostDao {
        return db.postDao()
    }

    @Singleton
    @Provides
    fun provideTodoDao(db: SamagraDb): TodoDao {
        return db.todoDao()
    }

    @Singleton
    @Provides
    fun providePhotoDao(db: SamagraDb): PhotoDao {
        return db.photoDao()
    }

    @Singleton
    @Provides
    fun provideCommentDao(db: SamagraDb): CommentDao {
        return db.commentDao()
    }
}
