package com.itxtest.rickandmorty.view.platform.base.view

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.itxtest.rickandmorty.view.platform.app.ApplicationClass
import com.itxtest.rickandmorty.view.platform.util.WindowMetrics

abstract class BaseDialog : Dialog(ApplicationClass.currentActivity) {

    companion object {
        private const val WIDTH_PERCENT = 0.8
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        val customView = getCustomDialogView()
        setContentView(customView)
        customView.layoutParams.width = (WindowMetrics.windowWidth * WIDTH_PERCENT).toInt()
        customView.layoutParams = customView.layoutParams
    }

    abstract fun getCustomDialogView(): View
}
