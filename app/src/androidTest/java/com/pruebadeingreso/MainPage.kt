package com.pruebadeingreso

import androidx.test.core.app.ActivityScenario

class MainPage : Page(){
    private lateinit var activityScenario: ActivityScenario<MainActivity>

    fun launch(): Page {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        return this
    }

    fun close(): MainPage {
        activityScenario.close()
        return this
    }
}