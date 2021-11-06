package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.happymoonday.challengesforheymoon.R
import androidx.navigation.fragment.findNavController
import com.happymoonday.challengesforheymoon.adapters.ChooseNationAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentChooseNationBinding
import com.happymoonday.challengesforheymoon.domain.enums.CountryType
import com.happymoonday.challengesforheymoon.presentation.base.BaseFragment
import com.happymoonday.challengesforheymoon.viewmodels.SearchViewModel

class ChooseNationFragment : BaseFragment() {

    override lateinit var binding: FragmentChooseNationBinding
    override val viewModel: SearchViewModel by navGraphViewModels(R.id.nav_graph_search_xml)

    private val adapter by lazy {
        ChooseNationAdapter {
            viewModel.reqMovie?.nation = it
            navigateToNation()
        }
    }

    private fun navigateToNation() {
        val action =
            ChooseNationFragmentDirections.actionFragmentChooseNationToFragmentKeywordSummary()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseNationBinding.inflate(inflater, container, false)

        binding.apply {
            textTitle.text = getString(
                R.string.msg_result_select_country,
                getString(viewModel.reqMovie?.genre?.toDescription ?: -1)
            )

            recyclerView.adapter = adapter

            subscribeUi(adapter)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun subscribeUi(adapter: ChooseNationAdapter) {
        val items = CountryType.findNationTypeList()
        adapter.submitList(items)

        viewModel.countries.observe(viewLifecycleOwner) { results ->
            adapter.submitList(results)
        }
    }

}