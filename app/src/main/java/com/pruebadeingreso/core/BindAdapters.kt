package com.pruebadeingreso.core

import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter


@BindingAdapter("android:show_hide")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}