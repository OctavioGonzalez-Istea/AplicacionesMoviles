package com.example.parcial2.network

import com.example.parcial2.data.model.Clima
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")  // Endpoint para obtener el clima actual
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): Response<Clima>

    @GET("forecast")  // Endpoint para obtener el clima de los próximos días
    suspend fun getWeatherForecast(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): Response<Clima>
}
