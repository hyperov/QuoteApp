package com.cyber.quoteapp.di.module

import com.cyber.quoteapp.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    internal abstract fun contributeMainActivityInjector(): MainActivity

}