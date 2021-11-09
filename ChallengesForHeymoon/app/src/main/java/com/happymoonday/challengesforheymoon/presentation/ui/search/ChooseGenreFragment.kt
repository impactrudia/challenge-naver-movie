package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.ChooseCommonAdapter
import com.happymoonday.challengesforheymoon.data.constants.Constants
import com.happymoonday.challengesforheymoon.databinding.FragmentChooseGenreBinding
import com.happymoonday.challengesforheymoon.domain.enums.GenreType
import com.happymoonday.challengesforheymoon.presentation.base.BaseFragment
import com.happymoonday.challengesforheymoon.viewmodels.SearchViewModel

class ChooseGenreFragment : BaseFragment() {

    override lateinit var binding: FragmentChooseGenreBinding
    override val viewModel: SearchViewModel by navGraphViewModels(R.id.nav_graph_search_xml)

    private val adapter by lazy {
        ChooseCommonAdapter {
            if(it is GenreType){
                viewModel.reqMovie?.genre = it
            }
            navigateToNation()
        }
    }

    private fun navigateToNation() {
        val action = ChooseGenreFragmentDirections.actionFragmentChooseGenreToFragmentNation()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseGenreBinding.inflate(inflater, container, false)

        binding.apply {
            viewModel.reqMovie?.keyword =
                requireActivity().intent.extras?.getString(Constants.BUNDLE_KEYWORD, "")
            textTitle.text = getString(R.string.msg_result_search_term, viewModel.reqMovie?.keyword)

            recyclerView.adapter = adapter

            subscribeUi(adapter)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun subscribeUi(adapter: ChooseCommonAdapter) {
        viewModel.genres.observe(viewLifecycleOwner) { results ->
            adapter.submitList(results)
        }
    }

}