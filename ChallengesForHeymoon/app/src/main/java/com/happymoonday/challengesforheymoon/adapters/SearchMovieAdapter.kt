package com.happymoonday.challengesforheymoon.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.ItemMovieFavoritesBinding
import com.happymoonday.challengesforheymoon.domain.model.Movie

class SearchMovieAdapter(
    private val onClick: (Movie) -> Unit
) : ListAdapter<Movie, SearchMovieAdapter.ViewHolder>(ChooseMovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie_favorites,
                parent,
                false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemMovieFavoritesBinding,
        private val onClick: (Movie) -> Unit
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie) {
            with(binding) {
                binding.item = movie
                setClickListener {
                    onClick(movie)
                }
                executePendingBindings()
            }
        }
    }

}


private class ChooseMovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}