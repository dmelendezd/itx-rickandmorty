package com.itxtest.rickandmorty.view.characterdetails.view

import com.itxtest.rickandmorty.model.domain.Character

interface CharacterDetailsView {
    fun getCharacter(): Character
    fun showCharacterName(characterName: String)
    fun showEpisodeName(episodeName: String)
    fun showEpisodeAirDate(airDate: String)
    fun showEpisodeCharacters(characters: List<Character>)
    fun showCharacterImage(imageUrl: String)
    fun close()
}
