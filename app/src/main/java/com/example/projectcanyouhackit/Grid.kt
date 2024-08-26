import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectcanyouhackit.R
import com.example.projectcanyouhackitpackage.NoteViewModel

@Composable
fun Grid(viewModel: NoteViewModel = viewModel()) {
    val notes by viewModel.notes.collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addNote("New Note") }) {
                Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "Add Note")
            }
        },
        content = {
            Column(modifier = Modifier.fillMaxSize().padding(it)) {
                LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
                    items(notes) { note ->
                        Card(modifier = Modifier.padding(8.dp)) {
                            Text(text = note.content, modifier = Modifier.padding(16.dp))
                        }
                    }
                }
            }
        }
    )
}