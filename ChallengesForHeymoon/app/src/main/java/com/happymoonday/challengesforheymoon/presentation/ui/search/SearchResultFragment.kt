package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.happymoonday.challengesforheymoon.R

class SearchResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_results, container, false)
    }

    fun showFavoriteAlert(){
        val alertDialog: AlertDialog? = this.let {
            val builder = AlertDialog.Builder(requireContext())
            builder.apply {
                setTitle(R.string.are_you_sure_you_want_to_add_this_movie_to_your_favorites)
                setPositiveButton(R.string.no,
                    { dialog, id ->
                    })
                setNegativeButton(R.string.yes,
                    { dialog, id ->
                    })
            }
            builder.create()
        }
        alertDialog?.show()
    }
}