package com.dhandyjoe.muviapp.ui

import android.os.Handler
import android.os.Looper
import androidx.paging.DataSource
import com.dhandyjoe.muviapp.EspressoIdlingResource
import com.dhandyjoe.muviapp.database.ConstantsMovie
import com.dhandyjoe.muviapp.database.ConstantsTVShow
import com.dhandyjoe.muviapp.local.FIlmDao
import com.dhandyjoe.muviapp.model.ModelFilm

class LocalDataSource private constructor(private val mFIlmDao: FIlmDao){

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var modelFilm: ModelFilm

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 1000


        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(fIlmDao: FIlmDao): LocalDataSource = instance ?: synchronized(this) {
            instance ?: LocalDataSource(fIlmDao).apply {
                instance = this
            }
        }
    }

    fun getListMovieDetail(callback: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({ callback.onAllMovieReceived(ConstantsMovie.getMovieList())
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getListTvShowDetail(callback: LoadTVCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTVReceived(ConstantsTVShow.getTVShowList())
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
    }

    fun setDetailFilm(model: ModelFilm) {
        modelFilm = model
    }

    fun getFilmDetail(callback: LoadDetailCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({ callback.onAllDetailReceived(modelFilm)
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
    }

    fun setFavoriteFilm(model: ModelFilm) {
        mFIlmDao.insertFavoriteFilm(model)
    }

    fun getFavoriteStatus(id: Int): Boolean {
        return mFIlmDao.getFavoriteStatus(id)
    }

    fun deleteFavoriteFilm(model: ModelFilm) {
        mFIlmDao.deleteFavoriteFilm(model)
    }

    fun getFavoriteMovie(): DataSource.Factory<Int, ModelFilm> = mFIlmDao.getFavoriteMovie()

    fun getFavoriteTVShow(): DataSource.Factory<Int, ModelFilm> = mFIlmDao.getFavoriteTVShow()

    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponses: ArrayList<ModelFilm>)
    }
    interface LoadTVCallback {
        fun onAllTVReceived(tvShowResponses: ArrayList<ModelFilm>)
    }

    interface LoadDetailCallback {
        fun onAllDetailReceived(detailResponse: ModelFilm)
    }
}