package com.cyber.quoteapp.model

import com.cyber.quoteapp.model.response.Quote
import io.reactivex.Single

interface Repository {

    fun getRandomQuote(): Single<Quote>

    fun insertQuote(quote: Quote): Long

    fun deleteQuote()

    var isNetworkConnected: Boolean
}