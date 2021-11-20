package com.dhandyjoe.muviapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhandyjoe.muviapp.viewmodel.ViewModelFactory
import com.dhandyjoe.muviapp.activity.DetailFilmActivity
import com.dhandyjoe.muviapp.adapter.FilmAdapter
import com.dhandyjoe.muviapp.databinding.FragmentTVShowBinding
import com.dhandyjoe.muviapp.model.ModelFilm
import com.dhandyjoe.muviapp.ui.MainViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TVShowFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentTVShowBinding
    private lateinit var viewModel: MainViewModel

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
        binding = FragmentTVShowBinding.inflate(layoutInflater, container, false)

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getDataTVShow().observe(viewLifecycleOwner, {
            binding.progressBar.visibility = View.GONE
            val movieAdapter = FilmAdapter(it)
            showTVList(movieAdapter)
            binding.rvTvShow.visibility = View.VISIBLE
        })

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TVShowFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun showTVList(data: FilmAdapter) {
        binding.rvTvShow.layoutManager = LinearLayoutManager(activity)
        binding.rvTvShow.adapter = data

        data.setOnItemClickCallback(object : FilmAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ModelFilm) {
                val intent = Intent(activity, DetailFilmActivity::class.java)
                intent.putExtra(DetailFilmActivity.EXTRA_FILM, data)
                startActivity(intent)
            }
        })
    }
}