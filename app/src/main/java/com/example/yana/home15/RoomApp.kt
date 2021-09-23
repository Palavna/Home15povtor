package com.example.yana.home15

import android.app.Application
import androidx.room.Room

class RoomApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DB = Room.databaseBuilder(this, AppDataBase::class.java, "myDB")
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        var DB: AppDataBase? = null
    }
}