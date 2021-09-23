package com.example.yana.home15

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NotesModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val  title: String?,
    val content: String?,
    val dataTv: String?
)


