package com.example.parcial2.domain.usecase

import com.example.parcial2.data.model.Ciudad
import com.example.parcial2.data.repository.CiudadRepository

class GuardarCiudadUseCase(private val ciudadRepository: CiudadRepository) {

    fun guardarCiudad(ciudad: Ciudad) {
        ciudadRepository.saveCiudad(ciudad)
    }

    fun getCiudadGuardada(): Ciudad? {
        return ciudadRepository.getCiudadGuardada()
    }
}
