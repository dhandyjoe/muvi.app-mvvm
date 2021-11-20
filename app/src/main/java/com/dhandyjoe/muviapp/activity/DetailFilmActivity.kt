package com.dhandyjoe.muviapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dhandyjoe.muviapp.R
import com.dhandyjoe.muviapp.databinding.ActivityDetailFilmBinding
import com.dhandyjoe.muviapp.model.ModelFilm
import com.dhandyjoe.muviapp.ui.DetailFilmViewModel
import com.dhandyjoe.muviapp.ui.MainViewModel
import com.dhandyjoe.muviapp.viewmodel.ViewModelFactory

class DetailFilmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFilmBinding
    private var statusFav = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Detail Film"

        val data = intent.getParcelableExtra<ModelFilm>(EXTRA_FILM)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        if (data != null) {
            viewModel.setDetail(data)
            viewModel.getDetail().observe(this, {
                binding.pbLoading.visibility = View.GONE
                binding.ivMovieDetail.setImageResource(it.poster)
                binding.tvTitleDetail.text = it.title.toString()
                binding.tvGenreDetails.text = it.genre
                binding.tvReleaseDateDetail.text = it.date
                binding.rvRatingDetail.rating = it.rating
                binding.rvRatingDetail.visibility = View.VISIBLE
                binding.tvSinopsisDetail.text = it.desc
                binding.textView.visibility = View.VISIBLE
                binding.ivFavoriteDetail.visibility = View.VISIBLE
                statusFavorite(it.id, viewModel)
            })
        }

        binding.ivFavoriteDetail.setOnClickListener {
            if (data != null) {
                if (statusFav) {
                    viewModel.deleteFavoriteFilm(data)
                    iconFavorite(false)
                } else {
                    viewModel.setFavoriteFIlm(data)
                    iconFavorite(true)
                }
            }
        }
    }

    companion object {
        val EXTRA_FILM = "extra_film"
    }

    fun iconFavorite(boolean: Boolean) {
        if(boolean) {
            statusFav = true
            binding.ivFavoriteDetail.setImageResource(R.drawable.ic_favorite)
        } else {
            statusFav = false
            binding.ivFavoriteDetail.setImageResource(R.drawable.ic_unfavorite)
        }
    }

    fun statusFavorite (id: Int, viewModel: DetailFilmViewModel) {
        val status = viewModel.getFavoriteStatus(id)

        if(status) {
            iconFavorite(true)
        } else {
            iconFavorite(false)
        }
    }
}