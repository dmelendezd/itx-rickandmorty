package com.itxtest.rickandmorty.view.platform.base.presenter

import com.itxtest.rickandmorty.view.navigation.NavigationManager

abstract class BasePresenter {

    protected val navigationManager get() = NavigationManager.getInstance()

    abstract fun onViewInitialized()
}
