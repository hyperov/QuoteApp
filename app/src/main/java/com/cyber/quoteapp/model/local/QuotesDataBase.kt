package com.cyber.quoteapp.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cyber.quoteapp.model.response.Quote

@Database(entities = [Quote::class], version = 1, exportSchema = false)
abstract class QuotesDataBase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDAO
}