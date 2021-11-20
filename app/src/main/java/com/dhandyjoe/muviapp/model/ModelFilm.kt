package com.dhandyjoe.muviapp.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "detailfilm")
data class ModelFilm(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "description")
    val desc: String?,

    @ColumnInfo(name = "genre")
    val genre: String?,

    @ColumnInfo(name = "poster")
    val poster: Int,

    @ColumnInfo(name = "date")
    val date: String?,

    @ColumnInfo(name = "rating")
    val rating: Float,

    @ColumnInfo(name = "is_movie")
    val isMovie: Boolean,
): Parcelable
