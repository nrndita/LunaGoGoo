package com.example.lunatiket.data.remote


import com.google.gson.annotations.SerializedName

data class DistanceToCity(
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: Double
)