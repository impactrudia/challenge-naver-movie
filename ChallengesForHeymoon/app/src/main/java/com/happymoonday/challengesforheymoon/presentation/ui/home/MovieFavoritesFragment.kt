package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.room.Room
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.adapters.SearchMovieAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentHomeViewPagerBinding
import com.happymoonday.challengesforheymoon.databinding.FragmentMovieFavoritesBinding
import com.happymoonday.challengesforheymoon.databinding.FragmentMovieSearchBinding
import com.happymoonday.challengesforheymoon.domain.constants.Constants
import com.happymoonday.challengesforheymoon.domain.database.AppDatabase
import com.happymoonday.challengesforheymoon.domain.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieFavoritesFragment : Fragment() {

    lateinit var binding: FragmentMovieFavoritesBinding
    /**
     * database instance
     */
    lateinit var db: AppDatabase
    private val adapter by lazy {
        SearchMovieAdapter {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, Constants.MOVIE_DB).build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieFavoritesBinding.inflate(inflater, container, false)

        binding.apply {
            recyclerView.adapter = adapter
        }

        CoroutineScope(Dispatchers.Default).launch {
            val movies = db.movieDao().getAll()
            requireActivity().runOnUiThread {
                if (isAdded) {
                    binding.hasFavoriteMovies = !movies.isNullOrEmpty()
                    subscribeUi(adapter, movies)
                }
            }
        }

        return binding.root
    }

    private fun subscribeUi(adapter: SearchMovieAdapter, movies: List<Movie>) {
        adapter.submitList(movies)
    }

}