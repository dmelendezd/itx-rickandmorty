package com.itxtest.rickandmorty.characterslist.view

import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.platform.base.view.BaseView

interface CharactersListView : BaseView {
    fun addCharacters(characters: List<Character>)
}
