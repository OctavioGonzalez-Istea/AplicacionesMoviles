package com.example.parcial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.parcial2.presentation.ui.ciudades.CiudadesScreen
import com.example.parcial2.presentation.ui.clima.ClimaScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "ciudades") {
                composable("ciudades") {
                    CiudadesScreen { ciudad ->
                        navController.navigate("clima/${ciudad.name}")
                    }
                }
                composable(
                    "clima/{ciudadName}",
                    arguments = listOf(navArgument("ciudadName") { type = NavType.StringType })
                ) { backStackEntry ->
                    val ciudadName = backStackEntry.arguments?.getString("ciudadName") ?: ""
                    val apiKey = "8b75696b269e81b8d624155011d30572"
                    ClimaScreen(ciudad = ciudadName, apiKey = apiKey)
                }
            }
        }
    }
}
