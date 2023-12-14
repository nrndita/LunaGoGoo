package com.example.lunatiket.data.remote.response

class AirportResponse : ArrayList<AirportResponseItem>()
data class AirportResponseItem(
    val city: String,
    val country: String,
    val elevation_ft: String,
    val iata: String,
    val icao: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val region: String,
    val timezone: String
)