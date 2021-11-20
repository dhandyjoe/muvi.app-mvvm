package com.dhandyjoe.muviapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dhandyjoe.muviapp.model.ModelFilm

class DetailFilmViewModel(val filmRepository: FilmRepository): ViewModel() {

    fun setDetail(model: ModelFilm) {
        filmRepository.setDetailFilm(model)
    }

    fun setFavoriteFIlm(model: ModelFilm) {
        filmRepository.setFavoriteFilm(model)
    }

    fun getFavoriteStatus(id: Int): Boolean {
        return filmRepository.getFavoriteStatus(id)
    }

    fun deleteFavoriteFilm(model: ModelFilm) {
        filmRepository.deleteFavoriteFilm(model)
    }

    fun getDetail(): LiveData<ModelFilm> = filmRepository.getDetailFilm()
}