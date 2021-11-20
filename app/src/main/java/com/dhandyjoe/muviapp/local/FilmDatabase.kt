package com.dhandyjoe.muviapp.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dhandyjoe.muviapp.model.ModelFilm

@Database(entities = [ModelFilm::class], version = 1, exportSchema = false)

abstract class FilmDatabase: RoomDatabase() {
    abstract fun filmDao(): FIlmDao

    companion object {
        @Volatile
        private var INSTANCE: FilmDatabase? = null

        fun getInstance(context: Context): FilmDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    FilmDatabase::class.java,
                    "Film.db"
                ).allowMainThreadQueries().build().apply {
                    INSTANCE = this
                }
            }
    }
}