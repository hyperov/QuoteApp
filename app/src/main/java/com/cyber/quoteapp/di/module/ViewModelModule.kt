package com.cyber.quoteapp.di.module

import androidx.lifecycle.ViewModelProvider
import com.cyber.quoteapp.di.module.RepositoryModule
import com.cyber.quoteapp.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}