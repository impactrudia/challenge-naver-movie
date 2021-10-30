package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.happymoonday.challengesforheymoon.databinding.FragmentMovieSearchBinding
import com.happymoonday.challengesforheymoon.domain.constants.Constants
import com.happymoonday.challengesforheymoon.presentation.ui.search.SearchActivity

class MovieSearchFragment : Fragment() {

    private lateinit var binding: FragmentMovieSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieSearchBinding.inflate(inflater, container, false)

        binding.btnSearchKeyword.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            intent.putExtra(Constants.BUNDLE_KEYWORD, binding.editInputSearch.text)
            startActivityForResult(intent, Constants.REQUEST_MOVIE_SEARCH)
        }

        return binding.root
    }

}