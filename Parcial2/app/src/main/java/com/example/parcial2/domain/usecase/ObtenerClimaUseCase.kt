package com.example.parcial2.domain.usecase

import com.example.parcial2.data.model.Clima
import com.example.parcial2.data.repository.ClimaRepository

class ObtenerClimaUseCase(private val repository: ClimaRepository) {

    suspend fun getCurrentWeather(cityName: String, apiKey: String): Clima? {
        return repository.getCurrentWeather(cityName, apiKey)
    }
}
