package com.dhandyjoe.muviapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dhandyjoe.muviapp.model.ModelFilm

class MainViewModel(val filmRepository: FilmRepository): ViewModel() {

    fun getDataMovie(): LiveData<ArrayList<ModelFilm>> = filmRepository.getMovieDetail()


    fun getDataTVShow(): LiveData<ArrayList<ModelFilm>> = filmRepository.getTvShowDetail()
}