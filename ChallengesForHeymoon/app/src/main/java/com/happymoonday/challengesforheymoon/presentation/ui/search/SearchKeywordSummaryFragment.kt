package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.FragmentSearchKeywordSummaryBinding

class SearchKeywordSummaryFragment : Fragment() {

    private lateinit var binding: FragmentSearchKeywordSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchKeywordSummaryBinding.inflate(inflater, container, false)

        binding.apply {
            btnSearchMovie.setOnClickListener {
                val action = SearchKeywordSummaryFragmentDirections.actionFragmentKeywordSummaryToFragmentKeywordResults()
                findNavController().navigate(action)
            }
        }
        return binding.root
    }

}