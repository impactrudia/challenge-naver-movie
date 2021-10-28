package com.happymoonday.challengesforheymoon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.ItemChooseNationBinding
import com.happymoonday.challengesforheymoon.domain.enums.GenreType
import com.happymoonday.challengesforheymoon.presentation.ui.search.ChooseGenreFragmentDirections
import com.happymoonday.challengesforheymoon.presentation.ui.search.ChooseNationFragmentDirections

class ChooseGenreAdapter :
    ListAdapter<GenreType, ChooseGenreAdapter.ChooseViewHolder>(
        ChooseNationDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseViewHolder {
        return ChooseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_choose_nation,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChooseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ChooseViewHolder(
        private val binding: ItemChooseNationBinding
    ) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.setClickListener { view ->
                navigateToNation(view)
            }
        }

        private fun navigateToNation(view: View){
            val action = ChooseGenreFragmentDirections.actionFragmentChooseGenreToFragmentNation()
            view.findNavController().navigate(action)
        }

        fun bind(genreType: GenreType) {
            with(binding) {
                executePendingBindings()
            }
        }
    }

}

private class ChooseNationDiffCallback : DiffUtil.ItemCallback<GenreType>() {
    override fun areItemsTheSame(oldItem: GenreType, newItem: GenreType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GenreType, newItem: GenreType): Boolean {
        return oldItem == newItem
    }
}