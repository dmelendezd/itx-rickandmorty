package com.itxtest.rickandmorty.view.platform.extension

import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.setBackgroundColorResource(@ColorRes colorId: Int) {
    backgroundTintList = ColorStateList.valueOf(context.getColor(colorId))
}

fun View.setMargins(top: Int, end: Int, bottom: Int, start: Int) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        (layoutParams as ViewGroup.MarginLayoutParams).setMargins(start, top, end, bottom)
        layoutParams = layoutParams
    }
}
