package com.cyber.quoteapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cyber.quoteapp.R
import com.cyber.quoteapp.viewmodel.MainViewModel
import com.cyber.quoteapp.viewmodel.ViewModelFactory
import com.food.arch.extensions.isNetworkAvailable
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        getQuote()
        subscribeToViewModel()
        setClickListener()
    }

    private fun setClickListener() {
        fbReset.setOnClickListener { viewModel.getQuote(isNetworkAvailable()) }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }


    private fun subscribeToViewModel() {
        viewModel.quoteLiveData.observe(this, Observer { quote ->
            tvQuote.text = quote.en
            tvAuthor.text = quote.author
        })

        viewModel.progressLiveData.observe(this, Observer { isProgress ->
            if (isProgress)
                progress.visibility = View.VISIBLE
            else
                progress.visibility = View.GONE
        })

        viewModel.errorLiveData.observe(this, Observer { error ->
            Snackbar.make(parentlayout, error!!, Snackbar.LENGTH_LONG).show()
            Log.e("subscribeToViewModel: ", error)
            progress.visibility = View.GONE
        })
    }

    private fun getQuote() {
        viewModel.getQuote(isNetworkAvailable())
    }
}