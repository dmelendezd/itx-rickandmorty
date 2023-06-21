package com.itxtest.rickandmorty.platform.base.presenter

import com.itxtest.rickandmorty.business.model.navigation.NavigationManager

abstract class BasePresenter {

    protected val navigationManager get() = NavigationManager.getInstance()

    abstract fun onViewInitialized()
}
