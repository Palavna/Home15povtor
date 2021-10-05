package com.example.yana.home15

interface UserListener {
    fun deleteItem(user: NotesModel)
    fun update(user: NotesModel)
    fun openDetails(user: NotesModel)
}