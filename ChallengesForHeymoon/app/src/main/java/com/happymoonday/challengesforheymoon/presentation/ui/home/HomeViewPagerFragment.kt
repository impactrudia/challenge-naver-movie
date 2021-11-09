package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.HomeViewPagerAdapter
import com.happymoonday.challengesforheymoon.adapters.MOVIE_FAVORITES_PAGE_INDEX
import com.happymoonday.challengesforheymoon.adapters.MOVIE_SEARCH_PAGE_INDEX
import com.happymoonday.challengesforheymoon.databinding.FragmentHomeViewPagerBinding

class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = HomeViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MOVIE_SEARCH_PAGE_INDEX -> getString(R.string.home)
            MOVIE_FAVORITES_PAGE_INDEX -> getString(R.string.favorites)
            else -> null
        }
    }

}