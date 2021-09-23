package com.example.yana.home15

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NotesModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}