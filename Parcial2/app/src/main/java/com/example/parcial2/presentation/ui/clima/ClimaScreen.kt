package com.example.parcial2.presentation.ui.clima

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ClimaScreen(
    viewModel: ClimaViewModel = viewModel(),
    ciudad: String,
    apiKey: String
) {
    // Llamar a obtenerClima al cargar la pantalla
    LaunchedEffect(Unit) {
        viewModel.obtenerClima(ciudad, apiKey)
    }

    // Observar el flujo de clima utilizando collectAsState
    val clima by viewModel.clima.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        clima?.let {
            // Mostrar información del clima si está disponible
            Text(
                text = "Clima en ${it.cityName}",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Temperatura actual: ${it.temperature}°C",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Mínima: ${it.minTemp}°C, Máxima: ${it.maxTemp}°C",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Descripción: ${it.description}",
                style = MaterialTheme.typography.bodySmall
            )
        } ?: Text(
            text = "Cargando datos...",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
