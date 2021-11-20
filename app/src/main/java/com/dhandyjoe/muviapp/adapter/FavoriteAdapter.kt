package com.dhandyjoe.muviapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dhandyjoe.muviapp.activity.DetailFilmActivity
import com.dhandyjoe.muviapp.databinding.ItemListFilmBinding
import com.dhandyjoe.muviapp.model.ModelFilm

class FavoriteAdapter: PagedListAdapter<ModelFilm, FavoriteAdapter.CourseViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ModelFilm>() {
            override fun areItemsTheSame(oldItem: ModelFilm, newItem: ModelFilm): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: ModelFilm, newItem: ModelFilm): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemListFilmBinding = ItemListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemListFilmBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = getItem(position)
        if (course != null) {
            holder.bind(course)
        }
    }

    class CourseViewHolder(private val binding: ItemListFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ModelFilm) {
            with(binding) {
                ivMovie.setImageResource(model.poster)
                binding.tvTitleMovie.text = model.title
                binding.tvDescMovie.text = model.desc
                binding.rbMovie.rating = model.rating
                itemView.setOnClickListener {
                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                        intent.putExtra(DetailFilmActivity.EXTRA_FILM, model)
                        itemView.context.startActivity(intent)
                    }
                }
            }
        }
    }
}