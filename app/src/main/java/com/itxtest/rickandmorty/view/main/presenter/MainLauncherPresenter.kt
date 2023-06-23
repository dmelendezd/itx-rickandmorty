package com.itxtest.rickandmorty.view.main.presenter

import com.itxtest.rickandmorty.view.characterslist.view.CharactersListLandingFragment
import com.itxtest.rickandmorty.view.platform.base.presenter.BasePresenter

class MainLauncherPresenter : BasePresenter() {

    override fun onViewInitialized() {
        navigationManager.navigateTo(CharactersListLandingFragment::class.java.canonicalName)
    }
}
