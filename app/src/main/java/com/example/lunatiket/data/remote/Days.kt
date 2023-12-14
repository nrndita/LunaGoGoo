package com.example.lunatiket.data.remote


import com.google.gson.annotations.SerializedName

data class Days(
    @SerializedName("Fri")
    val fri: Int,
    @SerializedName("Mon")
    val mon: Int,
    @SerializedName("Sat")
    val sat: Int,
    @SerializedName("Sun")
    val sun: Int,
    @SerializedName("Thu")
    val thu: Int,
    @SerializedName("Tue")
    val tue: Int,
    @SerializedName("Wed")
    val wed: Int
)