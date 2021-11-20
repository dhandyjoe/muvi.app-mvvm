package com.dhandyjoe.muviapp.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dhandyjoe.muviapp.fragment.MoviesFragment
import com.dhandyjoe.muviapp.fragment.TVShowFragment

class MainSectionPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val movies = MoviesFragment()
        val tvShow = TVShowFragment()

        var fragment: Fragment? = null

        when(position) {
            0 -> fragment = movies
            1 -> fragment = tvShow
        }

        return fragment as Fragment
    }
}