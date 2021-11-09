package com.happymoonday.challengesforheymoon.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.happymoonday.challengesforheymoon.R

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("resourceToString")
fun resourceToString(textView: TextView, @StringRes resourceId: Int) {
    textView.setText(resourceId)
}

@BindingAdapter("imageUrl")
fun loadPosterImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .placeholder(R.drawable.ic_baseline_movie_10)
        .into(view)
}

