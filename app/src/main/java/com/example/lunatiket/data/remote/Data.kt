package com.example.lunatiket.data.remote


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("city")
    val city: String,
    @SerializedName("cityName")
    val cityName: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("countryName")
    val countryName: String,
    @SerializedName("countryNameShort")
    val countryNameShort: String,
    @SerializedName("distanceToCity")
    val distanceToCity: DistanceToCity,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("parent")
    val parent: String,
    @SerializedName("photoUri")
    val photoUri: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("regionName")
    val regionName: String,

)