package com.emirhantekin.aicreatordemo

import android.app.Application
import com.emirhantekin.aicreatordemo.di.databaseModule
import com.emirhantekin.aicreatordemo.di.repositoryModule
import com.emirhantekin.aicreatordemo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(databaseModule, repositoryModule, viewModelModule)
        }
    }
}