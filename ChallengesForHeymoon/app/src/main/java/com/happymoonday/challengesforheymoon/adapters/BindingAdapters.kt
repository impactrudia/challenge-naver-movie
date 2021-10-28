package com.happymoonday.challengesforheymoon.adapters

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("resourceToString")
fun resourceToString(textView: TextView, @StringRes resourceId : Int){
    textView.setText(resourceId)
}
