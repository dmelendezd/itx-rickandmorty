package com.itxtest.rickandmorty.platform.extension

import android.view.View
import androidx.annotation.ColorRes

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.setBackgroundColorResource(@ColorRes colorId: Int) {
    setBackgroundColor(context.getColor(colorId))
}
