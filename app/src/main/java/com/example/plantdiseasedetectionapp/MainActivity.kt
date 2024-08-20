package com.example.plantdiseasedetectionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantdiseasedetectionapp.Screens.CureScreen
import com.example.plantdiseasedetectionapp.Screens.HomeScreen
import com.example.plantdiseasedetectionapp.Screens.LoginScreen
import com.example.plantdiseasedetectionapp.Screens.SignupScreen
import com.example.plantdiseasedetectionapp.navGraph.Navs
import com.example.plantdiseasedetectionapp.ui.theme.PlantDiseaseDetectionAppTheme
import com.example.plantdiseasedetectionapp.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewmodel : AuthViewModel by viewModels()


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantDiseaseDetectionAppTheme {

                val navController = rememberNavController()

                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){

                        NavHost(navController = navController, startDestination = Navs.Homescreen){
                            composable<Navs.Loginscreen> {
                                LoginScreen(navController,viewmodel)
                            }

                            composable<Navs.Homescreen> {
                                HomeScreen(navController,viewmodel)
                            }

                            composable<Navs.Signupscreen> {
                                SignupScreen(navController, viewmodel)
                            }
                            
                            composable<Navs.Curescreen> { 
                                CureScreen(viewModel = viewmodel, navController = navController)
                            }
                        }


                    }
                }
            }
        }
    }
}

