package com.example.lunatiket.data.remote


import com.google.gson.annotations.SerializedName

data class PesawatItem(
    @SerializedName("city")
    val city: String,
    @SerializedName("cityName")
    val cityName: String
)