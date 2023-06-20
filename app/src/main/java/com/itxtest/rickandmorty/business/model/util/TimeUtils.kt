package com.itxtest.rickandmorty.business.model.util

import java.time.Instant

object TimeUtils {
    val secondsFromEpoch: Long get() = Instant.now().epochSecond
}
