package com.cyber.quoteapp.model.local

import androidx.room.*
import com.cyber.quoteapp.model.response.Quote
import io.reactivex.Single

@Dao
interface QuoteDAO {

    @Query("SELECT * FROM quotes")
    fun getRandomQuote(): Single<Quote>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuote(quote: Quote): Long

    @Query("DELETE FROM quotes")
    fun deleteQuote()
}