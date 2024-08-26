package com.example.projectcanyouhackit

import androidx.room.PrimaryKey
import androidx.room.vo.Entity

@androidx.room.Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String
)