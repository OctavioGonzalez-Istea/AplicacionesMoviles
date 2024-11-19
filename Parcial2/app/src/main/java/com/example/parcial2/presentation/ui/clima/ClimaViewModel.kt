package com.example.parcial2.presentation.ui.clima

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial2.data.model.Clima
import com.example.parcial2.domain.usecase.ObtenerClimaUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClimaViewModel(private val obtenerClimaUseCase: ObtenerClimaUseCase) : ViewModel() {

    private val _clima = MutableStateFlow<Clima?>(null)
    val clima: StateFlow<Clima?> get() = _clima

    fun obtenerClima(ciudad: String, apiKey: String) {
        viewModelScope.launch {
            val result = obtenerClimaUseCase.getCurrentWeather(ciudad, apiKey)
            _clima.value = result
        }
    }
}
