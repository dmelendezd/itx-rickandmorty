package com.itxtest.rickandmorty.view.main.presenter

import com.itxtest.rickandmorty.view.characterslist.view.CharactersListLandingFragment
import com.itxtest.rickandmorty.view.main.view.dialog.HelpDialog
import com.itxtest.rickandmorty.view.platform.app.ApplicationClass
import com.itxtest.rickandmorty.view.platform.base.presenter.BasePresenter

class MainLauncherPresenter : BasePresenter() {

    override fun onViewInitialized() {
        navigationManager.navigateTo(CharactersListLandingFragment::class.java.canonicalName)
    }

    fun onHelpClicked() {
        HelpDialog().show()
    }

    fun onChangeListAppearanceClicked() {
        ApplicationClass.listAppearanceAlternate.postValue(
            ApplicationClass.listAppearanceAlternate.value?.not()
        )
    }
}
