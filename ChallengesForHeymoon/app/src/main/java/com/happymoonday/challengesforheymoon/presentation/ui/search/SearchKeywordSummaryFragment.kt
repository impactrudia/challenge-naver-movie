package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.FragmentSearchKeywordSummaryBinding
import com.happymoonday.challengesforheymoon.presentation.base.BaseFragment
import com.happymoonday.challengesforheymoon.viewmodels.SearchViewModel

class SearchKeywordSummaryFragment : BaseFragment() {

    override lateinit var binding: FragmentSearchKeywordSummaryBinding
    override val viewModel: SearchViewModel by navGraphViewModels(R.id.nav_graph_search_xml)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchKeywordSummaryBinding.inflate(inflater, container, false)

        binding.apply {
            viewModel.reqMovie?.let {
                textSummary.text = getString(
                    R.string.search_keyword_summary,
                    it.keyword,
                    getString(it.genre?.toDescription ?: -1),
                    getString(it.nation?.toDescription ?: -1)
                )
            }

            btnSearchMovie.setOnClickListener {
                val action =
                    SearchKeywordSummaryFragmentDirections.actionFragmentKeywordSummaryToFragmentKeywordResults()
                findNavController().navigate(action)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }

}