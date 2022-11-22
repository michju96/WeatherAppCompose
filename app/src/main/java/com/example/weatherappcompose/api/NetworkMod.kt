package com.example.weatherappcompose.ui.theme


import com.example.weatherappcompose.dto.Forecast
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.zip.Deflater

class NetworkMod {
    private val okHttpClient = OkHttpClient()

    val api by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAppComposeApi::class.java)
    }

    companion object {
        const val BASE_URL = "https://api.open-meteo.com/v1/"
    }
}

interface WeatherAppComposeApi {
    @GET("forecast")
    suspend fun showAll(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String
    ): Forecast
}