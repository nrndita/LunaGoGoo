package com.example.lunatiket.di

import androidx.room.Room
import com.example.lunatiket.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val RoomModule = module {
    single{
        Room.databaseBuilder(androidContext(), AppDatabase::class.java,"db")
            .fallbackToDestructiveMigration()
            .build()

    }
}