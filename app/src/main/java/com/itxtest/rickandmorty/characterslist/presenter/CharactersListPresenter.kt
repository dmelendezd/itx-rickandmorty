package com.itxtest.rickandmorty.characterslist.presenter

import com.itxtest.rickandmorty.characterslist.view.CharactersListView
import com.itxtest.rickandmorty.platform.base.presenter.BasePresenter

class CharactersListPresenter(private val view: CharactersListView) : BasePresenter() {

    override fun onViewInitialized() {
        view.showLoading()
        loadCharacters()
    }

    private fun loadCharacters() {

    }
}
