package com.dhandyjoe.muviapp.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dhandyjoe.muviapp.fragment.FavoriteMoviesFragment
import com.dhandyjoe.muviapp.fragment.FavoriteTVShowFragment

class FavoriteSectionPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val favoriteMovie = FavoriteMoviesFragment()
        val tvShowMovie = FavoriteTVShowFragment()

        var fragment: Fragment? = null

        when(position) {
            0 -> fragment = favoriteMovie
            1 -> fragment = tvShowMovie
        }

        return fragment as Fragment
    }
}