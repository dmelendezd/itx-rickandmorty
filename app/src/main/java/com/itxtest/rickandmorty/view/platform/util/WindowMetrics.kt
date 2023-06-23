package com.itxtest.rickandmorty.view.platform.util

import com.itxtest.rickandmorty.view.platform.app.ApplicationClass

object WindowMetrics {
    val windowWidth get() = ApplicationClass.currentActivity.resources.displayMetrics.widthPixels
}