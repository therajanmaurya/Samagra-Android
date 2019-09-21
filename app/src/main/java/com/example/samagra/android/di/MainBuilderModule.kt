package com.example.samagra.android.di

import com.example.samagra.android.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress("unused")
@Module
abstract class MainBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}
