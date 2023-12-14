package com.example.lunatiket.di

import com.example.lunatiket.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import org.koin.dsl.module

val networkModule= module{
    single {
        OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()
    }
    single{
        Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single{
        createApiService<ApiService>(get())
    }
}
inline fun <reified T> createApiService(retrofit: Retrofit):T = retrofit.create(T::class.java)