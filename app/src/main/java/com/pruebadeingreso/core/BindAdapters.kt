package com.pruebadeingreso.core

import android.view.View
import androidx.databinding.BindingAdapter

object BindAdapters {
    @BindingAdapter("android:visible_gone")
    fun showLoading(view: View, isShow: Boolean){
        view.visibility = if (isShow) View.VISIBLE else View.GONE
    }
}