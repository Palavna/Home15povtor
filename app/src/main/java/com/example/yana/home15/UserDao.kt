package com.example.yana.home15

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun saveUser(user: NotesModel)

    @Query("SELECT * FROM NotesModel")
    fun getAllUsers(): List<NotesModel>

    @Query("SELECT * FROM NotesModel")
    fun getAllUsersObserve(): LiveData<List<NotesModel>>

    @Delete
    fun deleteUser(user: NotesModel)

    @Update
    fun update(user: NotesModel?)

    @Query("SELECT * FROM NotesModel WHERE :userID = id LIMIT 1")
    fun getUser(userID:Int):NotesModel
}