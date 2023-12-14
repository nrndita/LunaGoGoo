package com.example.lunatiket.data.remote

import com.example.lunatiket.data.local.LocalRepository
import com.example.lunatiket.data.local.entity.UserEntity

class AppRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun insertUser(userEntity: UserEntity) {
        localRepository.insertUser(userEntity)

    }

    suspend fun getUser(email: String, password: String): UserEntity{
        return localRepository.getUser(email, password)
    }

    fun getUsers() = remoteRepository.getUsers()
}