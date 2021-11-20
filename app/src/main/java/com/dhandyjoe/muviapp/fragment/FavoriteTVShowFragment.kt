package com.dhandyjoe.muviapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhandyjoe.muviapp.adapter.FavoriteAdapter
import com.dhandyjoe.muviapp.databinding.FragmentFavoriteTVShowBinding
import com.dhandyjoe.muviapp.ui.FavoriteViewModel
import com.dhandyjoe.muviapp.viewmodel.ViewModelFactory

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FavoriteTVShowFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentFavoriteTVShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteTVShowBinding.inflate(inflater, container, false)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        viewModel.getTVShow().observe(viewLifecycleOwner, {
            binding.progressBar.visibility = View.GONE
            val movieAdapter = FavoriteAdapter()
            movieAdapter.submitList(it)
            movieAdapter.notifyDataSetChanged()

            binding.rvMovieFavorite.layoutManager = LinearLayoutManager(activity)
            binding.rvMovieFavorite.adapter = movieAdapter

            binding.rvMovieFavorite.visibility = View.VISIBLE
        })

        return binding.root
    }
}