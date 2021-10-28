package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.ChooseGenreAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentChooseGenreBinding
import com.happymoonday.challengesforheymoon.domain.enums.GenreType

class ChooseGenreFragment : Fragment() {

    private lateinit var binding: FragmentChooseGenreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseGenreBinding.inflate(inflater, container, false)

        binding.apply {
            textTitle.text = getString(R.string.msg_result_search_term, "test")//TODO FIX

            val adapter = ChooseGenreAdapter()
            recyclerView.adapter = adapter

            subscribeUi(adapter)
        }

        return binding.root
    }

    private fun subscribeUi(adapter: ChooseGenreAdapter) {
        val items = GenreType.findGenreTypeList()//TODO CHANGE
        adapter.submitList(items)
    }
}