package com.example.projectcanyouhackit

import Grid
import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.canyouhackit3.Voice_to_text
import com.example.projectcanyouhackit.ui.theme.ProjectCanYouHackItTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    private val mainViewModel = MainViewModel()
    val voiceToText by lazy {
        Voice_to_text(application)
    }

    @SuppressLint("UnusedContentLambdaTargetStateParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {
            ProjectCanYouHackItTheme {
                val authSate by mainViewModel.authState.collectAsState()

                LaunchedEffect(Unit) {
                    mainViewModel.checkAuthState()
                }
                when (authSate) {
                    AuthState.Authenticated -> MyNavigation(FirebaseAuth.getInstance())
                    AuthState.Unauthenticated -> LoginScreen(navController = rememberNavController())
                    else -> CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun MyNavigation(auth: FirebaseAuth) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen1(navController)
        }
        composable(Login.route) {
            LoginScreen(navController)
        }
        composable(Register.route) {
            RegisterScreen(navController)
        }
        composable(Grides.route) {
            MenuGrid(navController)
        }
        composable("noteGrid") {
            Grid()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    ProjectCanYouHackItTheme {
        Greeting("Android")
    }
}

class Myapplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}