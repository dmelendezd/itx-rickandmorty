package com.itxtest.rickandmorty.view.platform.util

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.itxtest.rickandmorty.view.platform.extension.gone
import com.itxtest.rickandmorty.view.platform.extension.visible

object ViewAnimationUtils {

    const val ANIM_DURATION_SHORT = 100L
    const val ANIM_DURATION_LONG = 300L

    fun showWithFade(view: View, duration: Long = ANIM_DURATION_LONG) {
        view.visible()
        val animation = AlphaAnimation(0f, 1f)
        animation.duration = duration
        view.startAnimation(animation)
    }

    fun hideWithFade(view: View, duration: Long = ANIM_DURATION_SHORT) {
        view.visible()
        val animation = AlphaAnimation(1f, 0f)
        animation.duration = duration
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                // Not used
            }

            override fun onAnimationRepeat(p0: Animation?) {
                // Not used
            }

            override fun onAnimationEnd(p0: Animation?) {
                view.gone()
            }
        })
        view.startAnimation(animation)
    }
}
