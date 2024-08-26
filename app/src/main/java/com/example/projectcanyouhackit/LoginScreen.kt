package com.example.projectcanyouhackit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by viewModel.loginState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B))
    ) {
        Image(painter = painterResource(id = R.drawable.fower_1), contentDescription = " ", modifier = Modifier.width(500.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF1B1B1B))
        ) {
            Text(text = "LOGIN", fontSize = 40.sp, fontStyle = FontStyle.Italic, color = Color.Yellow)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_person_24), contentDescription = null) },
                trailingIcon = {
                    if (email.isNotEmpty()) {
                        Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = null)
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Blue,
                    focusedLeadingIconColor = Color.Blue,
                    containerColor = Color.White
                ),
                textStyle = TextStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_password_24), contentDescription = null) },
                trailingIcon = {
                    if (password.isNotEmpty()) {
                        Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = null)
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Blue,
                    focusedLeadingIconColor = Color.Blue,
                    containerColor = Color.White
                ),
                textStyle = TextStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { viewModel.login(email, password) },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(Color.Yellow)
            ) {
                Text("LOGIN", color = Color.Black)
            }
            Spacer(modifier = Modifier.height(10.dp))
            when (loginState) {
                is LoginState.Loading -> CircularProgressIndicator()
                is LoginState.Success -> {
                    LaunchedEffect(Unit) {
                        navController.navigate(Grides.route)
                    }
                }
                is LoginState.Error -> Text((loginState as LoginState.Error).message, color = Color.Red)
                else -> {}
            }
            TextButton(onClick = { navController.navigate(Register.route) }) {
                Text("Don't have an account? Sign Up", color = Color.Yellow)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = R.drawable.can_you_hack_it_logo_6), contentDescription = " ")
    }
}