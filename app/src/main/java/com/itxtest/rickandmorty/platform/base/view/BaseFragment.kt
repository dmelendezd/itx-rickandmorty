package com.itxtest.rickandmorty.platform.base.view

import androidx.fragment.app.Fragment
import com.itxtest.rickandmorty.main.MainActivity

open class BaseFragment : Fragment(), BaseView {

    override fun showLoading() {
        if (activity is MainActivity) {
            (activity as MainActivity).showLoading()
        }
    }

    override fun hideLoading() {
        if (activity is MainActivity) {
            (activity as MainActivity).hideLoading()
        }
    }
}
