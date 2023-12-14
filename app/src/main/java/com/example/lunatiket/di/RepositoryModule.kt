package com.example.lunatiket.di

import com.example.lunatiket.data.local.LocalRepository
import com.example.lunatiket.data.remote.AppRepository
import com.example.lunatiket.data.remote.RemoteRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single { LocalRepository(get()) }
    single { RemoteRepository(get()) }
    single { AppRepository(get(), get()) }
}
