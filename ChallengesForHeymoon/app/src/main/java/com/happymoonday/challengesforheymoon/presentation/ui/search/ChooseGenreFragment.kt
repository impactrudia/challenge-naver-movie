package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.ChooseGenreAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentChooseGenreBinding
import com.happymoonday.challengesforheymoon.domain.enums.GenreType
import com.happymoonday.challengesforheymoon.presentation.base.BaseFragment

class ChooseGenreFragment : BaseFragment() {

    override lateinit var binding: FragmentChooseGenreBinding
    override val viewModel: SearchViewModel by navGraphViewModels(R.id.nav_graph_search_xml)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseGenreBinding.inflate(inflater, container, false)

        binding.apply {
            textTitle.text = getString(R.string.msg_result_search_term, viewModel.movie?.keyword)//TODO FIX

            val adapter = ChooseGenreAdapter()
            recyclerView.adapter = adapter

            subscribeUi(adapter)
        }

        viewModel.movie?.keyword = "test" //TODO FIX

        return binding.root
    }

    private fun subscribeUi(adapter: ChooseGenreAdapter) {
        val items = GenreType.findGenreTypeList()//TODO CHANGE
        adapter.submitList(items)
    }
}