package com.itxtest.rickandmorty.characterslist.presenter

import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.business.model.service.base.RequestObserver
import com.itxtest.rickandmorty.business.model.service.character.CharactersService
import com.itxtest.rickandmorty.characterslist.constant.CharactersListConstants
import com.itxtest.rickandmorty.characterslist.view.CharactersListView
import com.itxtest.rickandmorty.platform.base.presenter.BasePresenter

class CharactersListPresenter(private val view: CharactersListView) : BasePresenter() {

    private var nextCharacterId = 0

    override fun onViewInitialized() {
        view.showLoading()
        loadCharacters()
    }

    private fun loadCharacters() {
        CharactersService(getNextCharacterIds()).subscribe(object : RequestObserver<List<Character>>() {
            override fun onSuccess(response: List<Character>) {
                view.addCharacters(response)
                view.hideLoading()
            }
        }).start()
        nextCharacterId += CharactersListConstants.DEFAULT_PAGE_SIZE
    }

    private fun getNextCharacterIds(): List<Int> {
        return (nextCharacterId until nextCharacterId + CharactersListConstants.DEFAULT_PAGE_SIZE).toList()
    }
}
