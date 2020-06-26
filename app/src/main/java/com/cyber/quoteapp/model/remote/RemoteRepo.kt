package com.cyber.quoteapp.model.remote

import com.cyber.quoteapp.model.Repository
import com.cyber.quoteapp.model.response.Quote
import io.reactivex.Single
import javax.inject.Inject

class RemoteRepo @Inject constructor(val remoteNetwork: ApiEndPoints) : Repository {

    override fun getRandomQuote(): Single<Quote> {
        return remoteNetwork.getRandomQuote()
    }

    override fun insertQuote(quote: Quote): Long {
        throw Throwable("not implemented in Remote")
    }

    override fun deleteQuote() {
        throw Throwable("not implemented in Remote")
    }

    override var isNetworkConnected =true
}