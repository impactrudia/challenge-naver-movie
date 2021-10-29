package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.FragmentSearchKeywordSummaryBinding
import com.happymoonday.challengesforheymoon.presentation.base.BaseFragment

class SearchKeywordSummaryFragment : BaseFragment() {

    override lateinit var binding: FragmentSearchKeywordSummaryBinding
    override val viewModel: SearchViewModel by navGraphViewModels(R.id.nav_graph_search_xml)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchKeywordSummaryBinding.inflate(inflater, container, false)

        binding.apply {
            viewModel.movie?.let {
                textSummary.text = getString(R.string.search_keyword_summary, it.keyword, it.genre?.toDescription, it.nation?.toDescription)
            }

            btnSearchMovie.setOnClickListener {
                val action = SearchKeywordSummaryFragmentDirections.actionFragmentKeywordSummaryToFragmentKeywordResults()
                findNavController().navigate(action)
            }
        }

        return binding.root
    }

}