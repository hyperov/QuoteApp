package com.cyber.quoteapp.model.local

import com.cyber.quoteapp.model.Repository
import com.cyber.quoteapp.model.response.Quote
import io.reactivex.Single
import javax.inject.Inject

class LocalRepo @Inject constructor(val localNetwork: QuotesDataBase) : Repository {


    override fun getRandomQuote(): Single<Quote> {
        return localNetwork.quoteDao().getRandomQuote()
    }


    override fun insertQuote(quote: Quote): Long {
        return localNetwork.quoteDao().insertQuote(quote)
    }

    override fun deleteQuote() {
        localNetwork.quoteDao().deleteQuote()
    }

    override var isNetworkConnected = false
}