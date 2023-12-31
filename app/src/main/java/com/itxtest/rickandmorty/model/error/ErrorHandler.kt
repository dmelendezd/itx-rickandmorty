package com.itxtest.rickandmorty.model.error

import android.util.Log
import com.itxtest.rickandmorty.view.platform.app.ApplicationClass
import com.itxtest.rickandmorty.view.main.view.MainActivity

class ErrorHandler private constructor() {

    companion object {
        private var instance: ErrorHandler? = null

        fun getInstance(): ErrorHandler {
            if (instance == null) {
                instance = ErrorHandler()
            }

            return instance!!
        }
    }

    fun onServiceError(throwable: Throwable?) {
        Log.d(this::class.java.simpleName, throwable?.printStackTrace().toString())
        if (ApplicationClass.currentActivity is MainActivity) {
            (ApplicationClass.currentActivity as MainActivity).showErrorOverlay()
        }
    }
}
