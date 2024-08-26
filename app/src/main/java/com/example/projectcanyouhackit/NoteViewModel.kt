package com.example.projectcanyouhackitpackage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.projectcanyouhackit.Note
import com.example.projectcanyouhackit.NoteDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        NoteDatabase::class.java, "note-database"
    ).build()

    val notes: Flow<List<Note>> = db.noteDao().getAllNotes()

    fun addNote(content: String) {
        viewModelScope.launch {
            db.noteDao().insert(Note(content = content))
        }
    }
}