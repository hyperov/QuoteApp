package com.cyber.quoteapp.di.module

import android.content.Context
import androidx.room.Room
import com.cyber.quoteapp.model.local.QuotesDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    fun getDatabase(context: Context): QuotesDataBase {
        return Room.databaseBuilder(
            context,
            QuotesDataBase::class.java, "database-quotes"
        ).fallbackToDestructiveMigration().build()
    }
}