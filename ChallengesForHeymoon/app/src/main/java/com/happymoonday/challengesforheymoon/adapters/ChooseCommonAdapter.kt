package com.happymoonday.challengesforheymoon.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.ItemChooseGenreBinding
import com.happymoonday.challengesforheymoon.databinding.ItemChooseNationBinding
import com.happymoonday.challengesforheymoon.domain.enums.CountryType
import com.happymoonday.challengesforheymoon.domain.enums.GenreType

const val VIEW_TYPE_GENRE: Int = 0
const val VIEW_TYPE_COUNTRY: Int = 1

class ChooseCommonAdapter(
    private val onClick: (Any) -> Unit
) : ListAdapter<Any, RecyclerView.ViewHolder>(ChooseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_GENRE) {
            return ChooseGenreViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_choose_genre,
                    parent,
                    false
                ),
                onClick
            )
        } else {
            return ChooseNationViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_choose_nation,
                    parent,
                    false
                ),
                onClick
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item is GenreType) {
            (holder as ChooseGenreViewHolder).bind(item)
        } else if (item is CountryType) {
            (holder as ChooseNationViewHolder).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        if (item is GenreType) {
            return VIEW_TYPE_GENRE
        }
        return VIEW_TYPE_COUNTRY
    }

    class ChooseGenreViewHolder(
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

    class ChooseNationViewHolder(
        private val binding: ItemChooseNationBinding,
        private val onClick: (CountryType) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(countryType: CountryType) {
            with(binding) {
                item = countryType
                setClickListener {
                    onClick(countryType)
                }
                executePendingBindings()
            }
        }
    }

}

private class ChooseDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (oldItem is GenreType && newItem is GenreType) {
            return oldItem.id == newItem.id
        } else if (oldItem is CountryType && newItem is CountryType) {
            return oldItem.id == newItem.id
        }
        return false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (oldItem is GenreType && newItem is GenreType) {
            return oldItem == newItem
        } else if (oldItem is CountryType && newItem is CountryType) {
            return oldItem == newItem
        }
        return false
    }
}