package com.itxtest.rickandmorty.view.platform.base.view

import androidx.fragment.app.Fragment
import com.itxtest.rickandmorty.view.main.view.MainActivity

abstract class BaseFragment : Fragment(), BaseView {

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
