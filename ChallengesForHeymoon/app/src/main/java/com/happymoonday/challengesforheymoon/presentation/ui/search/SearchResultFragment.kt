package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.navGraphViewModels
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.FragmentSearchResultsBinding
import com.happymoonday.challengesforheymoon.presentation.base.BaseFragment

class SearchResultFragment : BaseFragment() {

    override lateinit var binding: FragmentSearchResultsBinding
    override val viewModel: SearchViewModel by navGraphViewModels(R.id.nav_graph_search_xml)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultsBinding.inflate(inflater, container, false)

        binding.apply {
            textEmptyMessage.setOnClickListener { //TODO FIX
                showFavoriteAlert()
            }
        }

        return binding.root
    }

    fun showFavoriteAlert(){
        val alertDialog: AlertDialog? = this.let {
            val builder = AlertDialog.Builder(requireContext())
            builder.apply {
                setTitle(R.string.are_you_sure_you_want_to_add_this_movie_to_your_favorites)
                setPositiveButton(R.string.no
                ) { dialog, id ->
                }
                setNegativeButton(R.string.yes
                ) { dialog, id ->
                    requireActivity().finish()
                    //TODO 탭 첫 번째로 이동
                }
            }
            builder.create()
        }
        alertDialog?.show()
    }
}