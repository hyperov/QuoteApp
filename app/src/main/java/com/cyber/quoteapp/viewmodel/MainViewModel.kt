package com.cyber.quoteapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cyber.quoteapp.model.Repository
import com.cyber.quoteapp.model.response.Quote
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val repo: Repository) : ViewModel() {

    private var compositeDisposable = CompositeDisposable()

    val quoteLiveData = MutableLiveData<Quote>()
    var errorLiveData = MutableLiveData<String>()
    var progressLiveData = MutableLiveData<Boolean>()

    val selectedCurrency = MutableLiveData<Pair<String, Double>>()

    fun getQuote(isNetwork: Boolean) {

        repo.isNetworkConnected = isNetwork
        progressLiveData.value = true

        compositeDisposable.add(repo.getRandomQuote()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { progressLiveData.value = false }
            .doOnSuccess {
                Observable.fromCallable { repo.deleteQuote() }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnComplete {
                        Observable.fromCallable { repo.insertQuote(it) }
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe()
                    }
                    .subscribe({ }, { t: Throwable? -> errorLiveData.value = t?.message })
            }
            .subscribe({ quoteLiveData.value = it!! },
                { e -> errorLiveData.value = e.message })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}