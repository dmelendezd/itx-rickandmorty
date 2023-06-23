package com.itxtest.rickandmorty.main.presenter

import com.itxtest.rickandmorty.characterslist.view.CharactersListLandingFragment
import com.itxtest.rickandmorty.platform.base.presenter.BasePresenter

class MainLauncherPresenter : BasePresenter() {

    override fun onViewInitialized() {
        navigationManager.navigateTo(CharactersListLandingFragment::class.java.canonicalName)
    }
}
