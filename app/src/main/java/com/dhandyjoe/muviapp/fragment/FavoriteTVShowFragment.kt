package com.dhandyjoe.muviapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhandyjoe.muviapp.R
import com.dhandyjoe.muviapp.activity.DetailFilmActivity
import com.dhandyjoe.muviapp.adapter.FavoriteAdapter
import com.dhandyjoe.muviapp.adapter.FilmAdapter
import com.dhandyjoe.muviapp.databinding.FragmentFavoriteTVShowBinding
import com.dhandyjoe.muviapp.model.ModelFilm
import com.dhandyjoe.muviapp.ui.FavoriteViewModel
import com.dhandyjoe.muviapp.viewmodel.ViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteTVShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoriteTVShowFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteTVShowFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}