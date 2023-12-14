package com.example.lunatiket.data.remote

import com.example.lunatiket.data.remote.response.AirportResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {
    @Headers("X-Api-Key: JdA17YlN4HL++QMOuH2TpQ==ROrd6UtNYqWT48bO")
    @GET("airports?country=ID")
    fun getAirport(): Call<List<AirportResponseItem>>
}