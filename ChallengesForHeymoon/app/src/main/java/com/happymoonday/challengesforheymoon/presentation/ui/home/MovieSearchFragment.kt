package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.MOVIE_FAVORITES_PAGE_INDEX
import com.happymoonday.challengesforheymoon.data.constants.Constants
import com.happymoonday.challengesforheymoon.databinding.FragmentMovieSearchBinding
import com.happymoonday.challengesforheymoon.presentation.base.CustomDialog
import com.happymoonday.challengesforheymoon.presentation.ui.search.SearchActivity

class MovieSearchFragment : Fragment() {

    private lateinit var binding: FragmentMovieSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieSearchBinding.inflate(inflater, container, false)

        binding.btnSearchKeyword.setOnClickListener {
            if (binding.editInputSearch.text.toString().trim().isEmpty()) {
                showAlert()
            } else {
                var intent = Intent(requireContext(), SearchActivity::class.java)
                intent.putExtra(Constants.BUNDLE_KEYWORD, binding.editInputSearch.text.toString())
                startForResult.launch(intent)
            }
        }

        return binding.root
    }

    /**
     * 영화 검색 API에 영화제목이 필수값이라 추가함.
     */
    private fun showAlert() {
        CustomDialog.showDefaultDialog(
            requireActivity(),
            getString(R.string.please_enter_a_search_term),
            textRight = getString(R.string.confirm),
            callbackRight = {
            })
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                requireActivity().findViewById<ViewPager2>(R.id.viewPager).currentItem =
                    MOVIE_FAVORITES_PAGE_INDEX
            }
        }

}