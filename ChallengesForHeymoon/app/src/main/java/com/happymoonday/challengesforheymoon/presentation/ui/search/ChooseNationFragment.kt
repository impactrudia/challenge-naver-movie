package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.ChooseGenreAdapter
import com.happymoonday.challengesforheymoon.adapters.ChooseNationAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentChooseGenreBinding
import com.happymoonday.challengesforheymoon.databinding.FragmentChooseNationBinding
import com.happymoonday.challengesforheymoon.domain.enums.CountryType
import com.happymoonday.challengesforheymoon.domain.enums.GenreType

class ChooseNationFragment : Fragment() {

    private lateinit var binding: FragmentChooseNationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseNationBinding.inflate(inflater, container, false)

        binding.apply {
            textTitle.text = getString(R.string.msg_result_select_country, "test")//TODO FIX

            val adapter = ChooseNationAdapter()
            recyclerView.adapter = adapter

            subscribeUi(adapter)
        }

        return binding.root
    }

    private fun subscribeUi(adapter: ChooseNationAdapter) {
        val items = CountryType.findNationTypeList()
        adapter.submitList(items)
    }

}