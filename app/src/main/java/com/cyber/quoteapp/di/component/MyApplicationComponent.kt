package com.cyber.quoteapp.di.component

import android.content.Context
import com.cyber.quoteapp.app.App
import com.cyber.quoteapp.di.module.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class]
)
interface MyApplicationComponent : AndroidInjector<App> {

    override fun inject(instance: App?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder

        fun build(): MyApplicationComponent
    }
}