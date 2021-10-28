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
import com.happymoonday.challengesforheymoon.domain.enums.CountryType
import com.happymoonday.challengesforheymoon.presentation.ui.search.ChooseNationFragmentDirections

class ChooseNationAdapter :
    ListAdapter<CountryType, ChooseNationAdapter.ChooseViewHolder>(
        ChooseDiffCallback()
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
            val action = ChooseNationFragmentDirections.actionFragmentChooseNationToFragmentKeywordSummary()
            view.findNavController().navigate(action)
        }

        fun bind(countryType: CountryType) {
            with(binding) {
                executePendingBindings()
            }
        }
    }

}

private class ChooseDiffCallback : DiffUtil.ItemCallback<CountryType>() {
    override fun areItemsTheSame(oldItem: CountryType, newItem: CountryType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CountryType, newItem: CountryType): Boolean {
        return oldItem == newItem
    }
}