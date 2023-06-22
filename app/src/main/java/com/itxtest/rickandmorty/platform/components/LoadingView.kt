package com.itxtest.rickandmorty.platform.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.itxtest.rickandmorty.R
import com.itxtest.rickandmorty.databinding.LoadingViewBinding
import com.itxtest.rickandmorty.platform.util.ViewAnimationUtils

class LoadingView(
    context: Context, attrs: AttributeSet?, defStyleArray: Int, defStyleRes: Int
) : FrameLayout(context, attrs, defStyleArray, defStyleRes) {
    constructor(context: Context, attrs: AttributeSet?, defStyleArray: Int): this(context, attrs, defStyleArray, -1)
    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, -1)
    constructor(context: Context): this(context, null)

    private val binding: LoadingViewBinding

    init {
        inflate(context, R.layout.loading_view, this)
        binding = LoadingViewBinding.bind(getChildAt(0))
    }

    fun show() {
        ViewAnimationUtils.showWithFade(this)
    }

    fun hide() {
        ViewAnimationUtils.hideWithFade(this)
    }
}
