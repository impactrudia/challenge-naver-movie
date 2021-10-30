package com.happymoonday.challengesforheymoon.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.happymoonday.challengesforheymoon.presentation.ui.home.FavoriteMoviesFragment
import com.happymoonday.challengesforheymoon.presentation.ui.home.MovieSearchFragment

const val MOVIE_SEARCH_PAGE_INDEX = 0
const val MOVIE_FAVORITES_PAGE_INDEX = 1

class HomeViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentCreators: Map<Int, () -> Fragment> = mapOf(
        MOVIE_SEARCH_PAGE_INDEX to { MovieSearchFragment() },
        MOVIE_FAVORITES_PAGE_INDEX to { FavoriteMoviesFragment() }
    )

    override fun getItemCount(): Int = tabFragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}