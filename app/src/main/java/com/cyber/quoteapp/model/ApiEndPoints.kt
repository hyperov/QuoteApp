package com.cyber.quoteapp.model

import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiEndPoints {

    @GET("quotes/random")
    fun getRandomQuote(): Single<Quote>


    companion object {
        const val BASE_URL = "https://programming-quotes-api.herokuapp.com/"

    }
}