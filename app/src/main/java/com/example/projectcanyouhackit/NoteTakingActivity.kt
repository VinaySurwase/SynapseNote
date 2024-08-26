package com.example.projectcanyouhackit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectcanyouhackitpackage.NoteViewModel

class NoteTakingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTakingScreen()
        }
    }
}

@Composable
fun NoteTakingScreen(viewModel: NoteViewModel = viewModel()) {
    val notes by viewModel.notes.collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addNote("New Note") }) {
                Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "Add Note")
            }
        },
        content = {
            Column(modifier = Modifier.fillMaxSize().padding(it)) {
                LazyColumn {
                    items(notes) { note ->
                        Text(text = note.content, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    )
}