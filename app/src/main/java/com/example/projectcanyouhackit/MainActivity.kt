package com.example.projectcanyouhackit

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectcanyouhackit.ui.theme.ProjectCanYouHackItTheme


class MainActivity : ComponentActivity() {
    val voiceToText by lazy {
        Voice_to_text(application)
    }
    @SuppressLint("UnusedContentLambdaTargetStateParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectCanYouHackItTheme{
                MyNavigation()
                /*var canRecord by remember {
                    mutableStateOf(false)

                }
                val recordAudioLauncher= rememberLauncherForActivityResult(contract =ActivityResultContracts.RequestPermission() , onResult ={isGranted->canRecord=isGranted} )
                LaunchedEffect(key1 = recordAudioLauncher) {
                    recordAudioLauncher.launch(Manifest.permission.RECORD_AUDIO)

                }
                val state by voiceToText.state.collectAsState()
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            if (state.isSpeaking) {
                                voiceToText.stopListening()
                            }else{
                                voiceToText.startListening()
                            }
                        }) {
                            AnimatedContent(targetState =state.isSpeaking ) { isSpeaking ->
                                if (isSpeaking){
                                    Image(imageVector = Icons.Rounded.Star, contentDescription =null )
                                }else{
                                    Image(imageVector = Icons.Rounded.Clear, contentDescription =null )
                                }

                            }

                        }
                    }
                ) {padding->
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(20.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        AnimatedContent(targetState = state.isSpeaking, label = "") {
                            if (it){
                                Text(text = "Speaking.....")

                            }else{
                                Text(text = state.spokenText.ifEmpty { "Click on mic to record audio" })

                            }

                        }




                    }

                }*/
                /*HomeScreen1()*/
                /*LoginScreen()*/
                /*RegisterScreen()*/
                /*NoteScreen()*/
                /*MenuGrid()*/

            }
        }
    }
}
@Composable
fun MyNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Home.route ){
        composable(Home.route){
            HomeScreen1(navController)
        }
        composable(Login.route){
            LoginScreen(navController)
        }
        composable(Register.route){
            RegisterScreen(navController)
        }
        composable(Grides.route){
            MenuGrid()
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectCanYouHackItTheme {
        Greeting("Android")
    }
}