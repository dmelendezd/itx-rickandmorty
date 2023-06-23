package com.itxtest.rickandmorty.view.characterslist.view

import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.view.platform.base.view.BaseView

interface CharactersListView : BaseView {
    fun addCharacters(characters: List<Character>)
}
