package com.example.lunatiket.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lunatiket.data.local.entity.UserEntity
import com.example.lunatiket.data.remote.AppRepository
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class RegisterViewModel(private val appRepository: AppRepository): ViewModel() {

    private val isRegister = MutableLiveData<Boolean>()
    val registerModule = module {
        viewModel { RegisterViewModel(get()) }
    }

    fun observeIsRegister(): LiveData<Boolean> = isRegister

    fun insertUser(user: UserEntity){
        viewModelScope.launch {
            try {
                appRepository.insertUser(user)
                isRegister.postValue(true)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}
