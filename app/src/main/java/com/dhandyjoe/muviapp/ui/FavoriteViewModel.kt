package com.dhandyjoe.muviapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dhandyjoe.muviapp.model.ModelFilm

class FavoriteViewModel(val filmRepository: FilmRepository): ViewModel() {

    fun getMovie(): LiveData<PagedList<ModelFilm>> = filmRepository.getFavoriteMovie()

    fun getTVShow(): LiveData<PagedList<ModelFilm>> = filmRepository.getFavoriteTvShow()

}