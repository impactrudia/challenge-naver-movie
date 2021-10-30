package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.happymoonday.challengesforheymoon.adapters.SearchMovieAdapter
import com.happymoonday.challengesforheymoon.databinding.FragmentFavoriteMoviesBinding
import com.happymoonday.challengesforheymoon.domain.constants.Constants
import com.happymoonday.challengesforheymoon.domain.database.AppDatabase
import com.happymoonday.challengesforheymoon.domain.model.Movie
import com.happymoonday.challengesforheymoon.presentation.ui.movieinfo.MovieInfoActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteMoviesFragment : Fragment() {

    lateinit var binding: FragmentFavoriteMoviesBinding
    /**
     * database instance
     */
    lateinit var db: AppDatabase
    private val adapter by lazy {
        SearchMovieAdapter {
            navigateToMovieInfoPage(it.link)
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
        binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)

        binding.apply {
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

}