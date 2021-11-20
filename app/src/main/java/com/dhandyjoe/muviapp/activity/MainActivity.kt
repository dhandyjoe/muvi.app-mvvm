package com.dhandyjoe.muviapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dhandyjoe.muviapp.R
import com.dhandyjoe.muviapp.adapter.MainSectionPagerAdapter
import com.dhandyjoe.muviapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "muvi.app"

        binding.ivFavorite.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }

        showTabsLayout()
    }

    private fun showTabsLayout() {
        val sectionPagerAdapter = MainSectionPagerAdapter(this)
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