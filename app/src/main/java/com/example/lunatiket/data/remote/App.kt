package com.example.lunatiket.data.remote

import android.app.Application
import com.example.lunatiket.di.RepositoryModule
import com.example.lunatiket.di.RoomModule
import com.example.lunatiket.di.networkModule
import com.example.lunatiket.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(listOf(
                networkModule,
                RepositoryModule,
                RoomModule,
                viewModelModule
            ))
        }
    }
}