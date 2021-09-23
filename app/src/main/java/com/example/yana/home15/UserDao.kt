package com.example.yana.home15

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun saveUser(user: NotesModel)

    @Query("SELECT * FROM NotesModel")
    fun getAllUsers(): List<NotesModel>
}