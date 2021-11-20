package com.dhandyjoe.muviapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dhandyjoe.muviapp.R
import com.dhandyjoe.muviapp.adapter.FavoriteSectionPagerAdapter
import com.dhandyjoe.muviapp.adapter.MainSectionPagerAdapter
import com.dhandyjoe.muviapp.databinding.ActivityFavoriteBinding
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Favorite Film"

        showTabsLayout()
    }

    private fun showTabsLayout() {
        val sectionPagerAdapter = FavoriteSectionPagerAdapter(this)
        val viewPager2 = binding.viewPager
        viewPager2.adapter = sectionPagerAdapter
        val tabs = binding.tabs

        TabLayoutMediator(tabs, viewPager2) { tab, position ->
            tab.text = resources.getString(TAB_TITLE[position])
        }.attach()
    }

    companion object {
        private val TAB_TITLE = intArrayOf(
            R.string.movies,
            R.string.tvshow
        )
    }
}