package com.itxtest.rickandmorty.locationdetails.util

import androidx.core.text.isDigitsOnly

object ResourceUrlUtil {

    private const val URL_PATH_SEPARATOR = "/"

    fun getIdFromUrl(locationUrl: String): Int {
        val split = locationUrl.split(URL_PATH_SEPARATOR)
        val id = split[split.lastIndex]
        return if (id.isDigitsOnly()) id.toInt() else 0
    }
}
