package com.dhandyjoe.muviapp.ui

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dhandyjoe.muviapp.model.ModelFilm

interface MovieDataSource {

    fun getMovieDetail(): LiveData<ArrayList<ModelFilm>>
    fun getTvShowDetail(): LiveData<ArrayList<ModelFilm>>

    fun setFavoriteFilm(modelFilm: ModelFilm)
    fun getFavoriteStatus(id: Int): Boolean
    fun deleteFavoriteFilm(modelFilm: ModelFilm)

    fun setDetailFilm(model: ModelFilm)
    fun getDetailFilm(): LiveData<ModelFilm>

    fun getFavoriteMovie(): LiveData<PagedList<ModelFilm>>
    fun getFavoriteTvShow(): LiveData<PagedList<ModelFilm>>

}