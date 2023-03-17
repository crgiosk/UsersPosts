package com.pruebadeingreso.extensions

import android.os.SystemClock
import android.view.View

class setSingleClickListener(
    private val block: () -> Unit,
    private val wait: Long = 1000L
) : View.OnClickListener {
    //todo!! remove this class

    private var lastClickTime = 0L

    override fun onClick(view: View) {
        if (SystemClock.elapsedRealtime() - lastClickTime < wait) {
            return
        }
        lastClickTime = SystemClock.elapsedRealtime()

        block()
    }
}