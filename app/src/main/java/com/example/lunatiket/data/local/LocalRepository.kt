package com.example.lunatiket.data.local

import com.example.lunatiket.data.local.entity.UserEntity

class LocalRepository(private val appDatabase: AppDatabase) {

    suspend fun insertUser(userEntity: UserEntity){
        appDatabase.userDao().insertUser(userEntity)
    }

    suspend fun getUser(email: String, password: String): UserEntity {
        return appDatabase.userDao().getUser(email, password)
    }
}


