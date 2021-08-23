package com.example.koshelok.ui

import android.app.Application
import android.content.Context
import com.example.koshelok.di.AppComponent
import com.example.koshelok.di.DaggerAppComponent


class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }
