package com.cyber.quoteapp.model

import com.cyber.quoteapp.annotations.Local
import com.cyber.quoteapp.annotations.Remote
import com.cyber.quoteapp.model.response.Quote
import io.reactivex.Single
import javax.inject.Inject

class MainRepo @Inject constructor(
    @Local val localRepository: Repository,
    @Remote val remoteRepository: Repository
) : Repository {

    override fun getRandomQuote(): Single<Quote> {
        return if (isNetworkConnected) remoteRepository.getRandomQuote() else localRepository.getRandomQuote()
    }

    override fun insertQuote(quote: Quote): Long {
        return localRepository.insertQuote(quote)
    }

    override fun deleteQuote() {
        return localRepository.deleteQuote()
    }

    override var isNetworkConnected = false
}