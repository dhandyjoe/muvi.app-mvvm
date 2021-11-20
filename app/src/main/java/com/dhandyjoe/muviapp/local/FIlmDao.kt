package com.dhandyjoe.muviapp.local

import androidx.paging.DataSource
import androidx.room.*
import com.dhandyjoe.muviapp.model.ModelFilm

@Dao
interface FIlmDao {

    @Query("SELECT * FROM detailfilm WHERE is_movie = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, ModelFilm>

    @Query("SELECT * FROM detailfilm WHERE is_movie = 0")
    fun getFavoriteTVShow(): DataSource.Factory<Int, ModelFilm>

    @Query("SELECT * FROM detailfilm WHERE id = :id")
    fun getFavoriteStatus(id: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteFilm(modelFilm: ModelFilm)

    @Delete
    fun deleteFavoriteFilm(modelFilm: ModelFilm)

}