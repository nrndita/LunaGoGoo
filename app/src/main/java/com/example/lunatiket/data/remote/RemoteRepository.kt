package com.example.lunatiket.data.remote

class RemoteRepository (private val apiService: ApiService){
    fun getUsers() = apiService.getAirport()
}

