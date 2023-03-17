package com.pruebadeingreso.core

import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged

object Extensions {

    fun View.setSingleClickListener(
        block: () -> Unit,
        blockInMillis: Long = 500
    ) {
        var lastClickTime: Long = 0
        this.setOnClickListener {
            if (SystemClock.elapsedRealtime() - lastClickTime < blockInMillis) return@setOnClickListener
            lastClickTime = SystemClock.elapsedRealtime()
            block.invoke()
        }
    }

    fun EditText.onAfterTextChanged(onTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(search: Editable?) {
                onTextChanged.invoke(search.toString())
            }

        })
    }
}