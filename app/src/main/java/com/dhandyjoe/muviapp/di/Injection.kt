package com.dhandyjoe.muviapp.di

import android.content.Context
import com.dhandyjoe.muviapp.local.FilmDatabase
import com.dhandyjoe.muviapp.ui.LocalDataSource
import com.dhandyjoe.muviapp.ui.FilmRepository

object Injection {
    fun provideRepository(context: Context): FilmRepository {
        val database = FilmDatabase.getInstance(context)

        val filmDataSource = LocalDataSource.getInstance(database.filmDao())

        return FilmRepository.getInstance(filmDataSource)
    }
}