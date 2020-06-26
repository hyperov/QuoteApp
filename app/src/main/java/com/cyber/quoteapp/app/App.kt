package com.cyber.quoteapp.app

import com.cyber.quoteapp.di.component.DaggerMyApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMyApplicationComponent.builder().application(context = this).build()
    }
}