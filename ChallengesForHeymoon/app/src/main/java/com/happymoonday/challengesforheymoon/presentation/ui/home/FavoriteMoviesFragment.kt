package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.room.Room
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.SearchMovieAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentFavoriteMoviesBinding
import com.happymoonday.challengesforheymoon.data.constants.Constants
import com.happymoonday.challengesforheymoon.data.database.AppDatabase
import com.happymoonday.challengesforheymoon.domain.model.Movie
import com.happymoonday.challengesforheymoon.presentation.base.CustomDialog
import com.happymoonday.challengesforheymoon.presentation.ui.movieinfo.MovieInfoActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteMoviesFragment : Fragment() {

    lateinit var binding: FragmentFavoriteMoviesBinding
    lateinit var db: AppDatabase
    private val adapter by lazy {
        SearchMovieAdapter({
            navigateToMovieInfoPage(it.link)
        }, {
            showDeleteMovieAlert(it)
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
        binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)

        binding.apply {
            recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
            recyclerView.adapter = adapter
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        getAllMovie()
    }

    private fun getAllMovie() {
        CoroutineScope(Dispatchers.Default).launch {
            val movies = db.movieDao().getAll()
            requireActivity().runOnUiThread {
                if (isAdded) {
                    binding.hasFavoriteMovies = !movies.isNullOrEmpty()
                    subscribeUi(adapter, movies)
                }
            }
        }
    }

    private fun subscribeUi(adapter: SearchMovieAdapter, movies: List<Movie>) {
        adapter.submitList(movies)
    }

    private fun navigateToMovieInfoPage(link: String) {
        val intent = Intent(requireActivity(), MovieInfoActivity::class.java)
        intent.putExtra(Constants.BUNDLE_LINK, link)
        startActivity(intent)
    }

    private fun showDeleteMovieAlert(movie: Movie) {
        CustomDialog.showDefaultDialog(
            requireContext(),
            getString(R.string.are_you_sure_you_want_to_delete_this_movie_to_your_favorites),
            callbackLeft = {
            },
            callbackRight = {
                CoroutineScope(Dispatchers.Default).launch {
                    db.movieDao().deleteByUuid(movie.uuid)
                }
                getAllMovie()
            })
    }

}