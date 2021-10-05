package com.example.yana.home15

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NotesModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String?,
    var content: String?,
    var dataTv: String?
)


