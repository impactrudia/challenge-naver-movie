package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.FragmentHomeViewPagerBinding
import com.happymoonday.challengesforheymoon.databinding.FragmentMovieFavoritesBinding
import com.happymoonday.challengesforheymoon.databinding.FragmentMovieSearchBinding

class MovieFavoritesFragment : Fragment() {

    lateinit var binding: FragmentMovieFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieFavoritesBinding.inflate(inflater, container, false)

        return binding.root
    }

}