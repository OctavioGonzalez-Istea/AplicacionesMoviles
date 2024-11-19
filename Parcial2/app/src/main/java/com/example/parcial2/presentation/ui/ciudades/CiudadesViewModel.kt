package com.example.parcial2.presentation.ui.ciudades

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial2.data.model.Ciudad
import com.example.parcial2.domain.usecase.GuardarCiudadUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class CiudadesViewModel(private val guardarCiudadUseCase: GuardarCiudadUseCase) : ViewModel() {

    private val _ciudades = MutableStateFlow<List<Ciudad>>(emptyList())
    val ciudades: StateFlow<List<Ciudad>> get() = _ciudades

    fun buscarCiudad(nombre: String) {
        _ciudades.value = listOf(
            Ciudad(name = "Ciudad A", latitude = 0.0, longitude = 0.0),
            Ciudad(name = "Ciudad B", latitude = 1.0, longitude = 1.0),
            Ciudad(name = "Ciudad C", latitude = 2.0, longitude = 2.0)
        ).filter { it.name.contains(nombre, ignoreCase = true) }
    }

    fun seleccionarCiudad(ciudad: Ciudad) {
        viewModelScope.launch {
            guardarCiudadUseCase.guardarCiudad(ciudad)
        }
    }
}
