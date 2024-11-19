package com.example.parcial2.presentation.ui.ciudades

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.parcial2.data.model.Ciudad


@Composable
fun CiudadesScreen(
    viewModel: CiudadesViewModel = viewModel(),
    onCiudadSeleccionada: (Ciudad) -> Unit
) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Campo de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar ciudad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de búsqueda
        Button(
            onClick = { viewModel.buscarCiudad(searchQuery.text) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de resultados
        val ciudades = viewModel.ciudades.collectAsState().value
        LazyColumn {
            items(ciudades) { ciudad ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onCiudadSeleccionada(ciudad) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = ciudad.name, style = MaterialTheme.typography.titleMedium)
                        Text(
                            text = "Latitud: ${ciudad.latitude}, Longitud: ${ciudad.longitude}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
