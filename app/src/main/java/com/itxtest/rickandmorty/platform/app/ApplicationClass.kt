package com.itxtest.rickandmorty.platform.app

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application

class ApplicationClass : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var currentActivity: Activity
    }
}
