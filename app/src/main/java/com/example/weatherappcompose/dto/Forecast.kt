package com.example.weatherappcompose.dto
import com.google.gson.annotations.SerializedName


data class Forecast(
    @SerializedName("elevation")
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("hourly")
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int
)

data class Hourly(
    @SerializedName("temperature_2m")
    val temperature2m: List<String>,
    @SerializedName("time")
    val time: List<String>
)

data class HourlyUnits(
    @SerializedName("temperature_2m")
    val temperature2m: String,
    @SerializedName("time")
    val time: String
)
