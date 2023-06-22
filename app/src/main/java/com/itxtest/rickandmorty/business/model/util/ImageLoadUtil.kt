package com.itxtest.rickandmorty.business.model.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageLoadUtil {

    fun load(imageUrl: String, into: ImageView) {
        Glide.with(into.context).load(imageUrl).into(into)
    }
}
