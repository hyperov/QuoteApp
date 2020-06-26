package com.cyber.quoteapp.model.remote

import com.cyber.quoteapp.model.response.Quote
import io.reactivex.Single
import retrofit2.http.GET

interface ApiEndPoints {

    @GET("quotes/random")
    fun getRandomQuote(): Single<Quote>


    companion object {
        const val BASE_URL = "https://programming-quotes-api.herokuapp.com/"

    }
}