package com.example.lunatiket.di

import com.example.lunatiket.ui.login.LoginViewModel
import com.example.lunatiket.ui.register.RegisterViewModel
import org.koin.dsl.module

val viewModelModule = module{
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
}