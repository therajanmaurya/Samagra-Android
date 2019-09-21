package com.example.samagra.android.di

import com.example.samagra.android.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
