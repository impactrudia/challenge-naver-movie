package com.happymoonday.challengesforheymoon.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.databinding.ItemChooseNationBinding
import com.happymoonday.challengesforheymoon.domain.enums.CountryType

class ChooseNationAdapter(
    private val onClick: (CountryType) -> Unit
): ListAdapter<CountryType, ChooseNationAdapter.ChooseViewHolder>(ChooseNationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseViewHolder {
        return ChooseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_choose_nation,
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
        private val binding: ItemChooseNationBinding,
        private val onClick: (CountryType) -> Unit
    ) : RecyclerView.ViewHolder(binding.root){

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

private class ChooseNationDiffCallback : DiffUtil.ItemCallback<CountryType>() {
    override fun areItemsTheSame(oldItem: CountryType, newItem: CountryType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CountryType, newItem: CountryType): Boolean {
        return oldItem == newItem
    }
}