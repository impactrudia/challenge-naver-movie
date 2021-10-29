package com.happymoonday.challengesforheymoon.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.ItemChooseGenreBinding
import com.happymoonday.challengesforheymoon.domain.enums.GenreType

class ChooseGenreAdapter(
    private val onClick: (GenreType) -> Unit
) : ListAdapter<GenreType, ChooseGenreAdapter.ChooseViewHolder>(ChooseGenreDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseViewHolder {
        return ChooseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_choose_genre,
                parent,
                false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(holder: ChooseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ChooseViewHolder(
        private val binding: ItemChooseGenreBinding,
        private val onClick: (GenreType) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(genreType: GenreType) {
            with(binding) {
                item = genreType
                setClickListener {
                    onClick(genreType)
                }
                executePendingBindings()
            }
        }
    }

}

private class ChooseGenreDiffCallback : DiffUtil.ItemCallback<GenreType>() {
    override fun areItemsTheSame(oldItem: GenreType, newItem: GenreType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GenreType, newItem: GenreType): Boolean {
        return oldItem == newItem
    }
}