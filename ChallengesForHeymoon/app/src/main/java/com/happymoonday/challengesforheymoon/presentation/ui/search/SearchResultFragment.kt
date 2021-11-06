package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.app.Activity.RESULT_OK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.room.Room
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.SearchMovieAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentSearchResultsBinding
import com.happymoonday.challengesforheymoon.data.constants.Constants
import com.happymoonday.challengesforheymoon.data.database.AppDatabase
import com.happymoonday.challengesforheymoon.domain.model.Movie
import com.happymoonday.challengesforheymoon.presentation.base.BaseFragment
import com.happymoonday.challengesforheymoon.presentation.base.CustomDialog
import com.happymoonday.challengesforheymoon.viewmodels.SearchViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchResultFragment : BaseFragment() {

    override lateinit var binding: FragmentSearchResultsBinding
    override val viewModel: SearchViewModel by navGraphViewModels(R.id.nav_graph_search_xml)
    lateinit var db: AppDatabase
    private val adapter by lazy {
        SearchMovieAdapter({
            showFavoriteAlert(it)
        }, {
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, Constants.MOVIE_DB)
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultsBinding.inflate(inflater, container, false)

        binding.apply {
            textEmptyMessage.setOnClickListener {
                requireActivity().finish()
            }

            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            recyclerView.adapter = adapter

            subscribeUi(adapter)
        }

        return binding.root
    }

    private fun subscribeUi(adapter: SearchMovieAdapter) {
        viewModel.requestSearchMovie({
            val items = it.items
            adapter.submitList(items)
            binding.hasSearchMovies = !items.isNullOrEmpty()
        }, {
            binding.hasSearchMovies = false
        })
    }

    private fun showFavoriteAlert(movie: Movie?) {
        CustomDialog.showDefaultDialog(
            requireContext(),
            getString(R.string.are_you_sure_you_want_to_add_this_movie_to_your_favorites),
            callbackLeft = {
            },
            callbackRight = {
                if (movie != null) {
                    CoroutineScope(Dispatchers.Default).launch {
                        db.movieDao().insertMovie(movie)
                    }
                    moveToHome()
                } else {
                    moveToHome()
                }
            })
    }

    private fun moveToHome() {
        requireActivity().setResult(RESULT_OK)
        requireActivity().finish()
    }

}