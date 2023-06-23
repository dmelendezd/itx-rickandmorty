package com.itxtest.rickandmorty.view.platform.app

import android.annotation.SuppressLint
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData

class ApplicationClass : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var currentActivity: AppCompatActivity

        val listAppearanceAlternate = MutableLiveData(false)
    }
}
