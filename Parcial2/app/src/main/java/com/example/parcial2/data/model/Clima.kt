package com.example.parcial2.data.model

data class Clima(
    val cityName: String,
    val temperature: Double,
    val description: String,
    val icon: String,
    val minTemp: Double,
    val maxTemp: Double
)

// Clase que representa la información del clima en una ciudad.
// Incluye nombre, temperatura, descripción, ícono y temperaturas mínima y máxima.
