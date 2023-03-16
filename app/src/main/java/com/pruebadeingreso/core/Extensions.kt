package com.pruebadeingreso.core

import android.os.SystemClock
import android.view.View

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
}