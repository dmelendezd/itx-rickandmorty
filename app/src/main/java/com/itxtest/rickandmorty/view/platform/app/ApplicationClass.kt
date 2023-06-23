package com.itxtest.rickandmorty.view.platform.app

import android.annotation.SuppressLint
import android.app.Application
import androidx.appcompat.app.AppCompatActivity

class ApplicationClass : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var currentActivity: AppCompatActivity
    }
}
