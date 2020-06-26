package com.cyber.quoteapp.di.module

import com.cyber.quoteapp.annotations.Local
import com.cyber.quoteapp.annotations.Main
import com.cyber.quoteapp.annotations.Remote
import com.cyber.quoteapp.di.module.DataBaseModule
import com.cyber.quoteapp.di.module.NetworkModule
import com.cyber.quoteapp.model.MainRepo
import com.cyber.quoteapp.model.Repository
import com.cyber.quoteapp.model.local.LocalRepo
import com.cyber.quoteapp.model.remote.RemoteRepo
import dagger.Binds
import dagger.Module


@Module(includes = [NetworkModule::class, DataBaseModule::class])
abstract class RepositoryModule {

    @Binds
    @Local
    abstract fun provideTasksLocalDataSource(repo: LocalRepo): Repository

    @Binds
    @Remote
    abstract fun provideTasksRemoteDataSource(repo: RemoteRepo): Repository

    @Binds
    @Main
    abstract fun provideTasksMainDataSource(repo: MainRepo): Repository
}