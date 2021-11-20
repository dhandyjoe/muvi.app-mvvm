package com.dhandyjoe.muviapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dhandyjoe.muviapp.model.ModelFilm

class FakeFilmRepository(private val localDataSource: LocalDataSource): MovieDataSource {

    companion object {

        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(
            filmDataSource: LocalDataSource
        ): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(filmDataSource).apply {
                    instance = this
                }
            }

    }

    override fun getMovieDetail(): LiveData<ArrayList<ModelFilm>> {
        val movieResult = MutableLiveData<ArrayList<ModelFilm>>()

        localDataSource.getListMovieDetail(object : LocalDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponses: ArrayList<ModelFilm>) {
                val movieList = ArrayList<ModelFilm>()
                for (response in movieResponses) {
                    val movie = ModelFilm(
                        response.id,
                        response.title,
                        response.desc,
                        response.genre,
                        response.poster,
                        response.date,
                        response.rating,
                        response.isMovie,
                    )
                    movieList.add(movie)
                }
                movieResult.postValue(movieResponses)
            }
        })

        return movieResult
    }

    override fun getTvShowDetail(): LiveData<ArrayList<ModelFilm>> {
        val tvShowResult = MutableLiveData<ArrayList<ModelFilm>>()

        localDataSource.getListTvShowDetail(object : LocalDataSource.LoadTVCallback{
            override fun onAllTVReceived(tvShowResponses: ArrayList<ModelFilm>) {
                val tvShowList = ArrayList<ModelFilm>()
                for (response in tvShowResponses) {
                    val movie = ModelFilm(
                        response.id,
                        response.title,
                        response.desc,
                        response.genre,
                        response.poster,
                        response.date,
                        response.rating,
                        response.isMovie,
                    )
                    tvShowList.add(movie)
                }
                tvShowResult.postValue(tvShowResponses)
            }
        })
        return tvShowResult
    }

    override fun setFavoriteFilm(modelFilm: ModelFilm) {
        localDataSource.setFavoriteFilm(modelFilm)
    }

    override fun getFavoriteStatus(id: Int): Boolean {
        return localDataSource.getFavoriteStatus(id)
    }

    override fun deleteFavoriteFilm(modelFilm: ModelFilm) {
        localDataSource.deleteFavoriteFilm(modelFilm)
    }

    override fun setDetailFilm(model: ModelFilm) {
        localDataSource.setDetailFilm(model)
    }

    override fun getDetailFilm(): LiveData<ModelFilm> {
        val detailResult = MutableLiveData<ModelFilm>()

        localDataSource.getFilmDetail(object : LocalDataSource.LoadDetailCallback{
            override fun onAllDetailReceived(detailResponse: ModelFilm) {
                val movie = ModelFilm(
                    detailResponse.id,
                    detailResponse.title,
                    detailResponse.desc,
                    detailResponse.genre,
                    detailResponse.poster,
                    detailResponse.date,
                    detailResponse.rating,
                    detailResponse.isMovie,
                )
                detailResult.postValue(movie)
            }
        })
        return detailResult
    }

    override fun getFavoriteMovie(): LiveData<PagedList<ModelFilm>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<ModelFilm>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteTVShow(), config).build()
    }
}