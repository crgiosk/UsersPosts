package com.users_posts.core

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("android:show_hide")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}