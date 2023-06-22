package com.itxtest.rickandmorty.characterdetails.view

import com.itxtest.rickandmorty.business.model.domain.Character

interface CharacterDetailsView {
    fun getCharacter(): Character
    fun showCharacterName(characterName: String)
    fun showEpisodeName(episodeName: String)
    fun showEpisodeAirDate(airDate: String)
    fun showEpisodeCharacters(characters: List<Character>)
    fun showBackgroundImage(imageUrl: String)
}
