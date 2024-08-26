package com.example.projectcanyouhackit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuGrid(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = { navController.navigate("noteGrid") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Notes")
        }
        // Add other buttons here
    }
}