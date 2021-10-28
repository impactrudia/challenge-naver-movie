package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.FragmentMovieSearchBinding
import com.happymoonday.challengesforheymoon.presentation.ui.search.SearchActivity

class MovieSearchFragment : Fragment() {

    private lateinit var binding: FragmentMovieSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieSearchBinding.inflate(inflater, container, false)

        binding.btnSearchKeyword.setOnClickListener {
            startActivity(Intent(requireContext(), SearchActivity::class.java))
        }

        return binding.root
    }

}