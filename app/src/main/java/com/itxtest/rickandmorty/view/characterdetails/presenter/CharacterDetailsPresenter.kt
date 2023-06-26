package com.itxtest.rickandmorty.view.characterdetails.presenter

import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.domain.Episode
import com.itxtest.rickandmorty.model.service.base.RequestObserver
import com.itxtest.rickandmorty.model.service.character.CharactersService
import com.itxtest.rickandmorty.model.service.episode.EpisodesService
import com.itxtest.rickandmorty.view.characterdetails.view.CharacterDetailsOverlay
import com.itxtest.rickandmorty.view.characterdetails.view.CharacterDetailsView
import com.itxtest.rickandmorty.view.locationdetails.util.ResourceUrlUtil
import com.itxtest.rickandmorty.view.platform.base.presenter.BasePresenter

class CharacterDetailsPresenter(private val view: CharacterDetailsView) : BasePresenter() {

    override fun onViewInitialized() {
        val character = view.getCharacter()
        view.showCharacterName(character.name)
        view.showCharacterImage(character.image)
        loadFirstSeenEpisode(character)
    }

    fun onOtherCharacterClicked(character: Character) {
        CharacterDetailsOverlay.newInstance(character).show()
    }

    fun onCloseClicked() {
        view.close()
    }

    private fun loadFirstSeenEpisode(character: Character) {
        if (character.episode.isNotEmpty()) {
            val firstSeenEpisodeId = ResourceUrlUtil.getIdFromUrl(character.episode[0])
            EpisodesService(listOf(firstSeenEpisodeId)).subscribe(object : RequestObserver<List<Episode>>() {
                override fun onSuccess(response: List<Episode>) {
                    if (response.isNotEmpty()) {
                        view.showEpisodeName(getEpisodeFormattedName(response[0]))
                        view.showEpisodeAirDate(response[0].airDate)
                        loadEpisodeCharacters(response[0])
                    }
                }
            }).start()
        }
    }

    private fun loadEpisodeCharacters(episode: Episode) {
        if (episode.characters.isNotEmpty()) {
            val characterIds = episode.characters.map { ResourceUrlUtil.getIdFromUrl(it) }
            CharactersService(characterIds).subscribe(object : RequestObserver<List<Character>>() {
                override fun onSuccess(response: List<Character>) {
                    view.showEpisodeCharacters(response)
                }
            }).start()
        }
    }

    private fun getEpisodeFormattedName(episode: Episode): String {
        return "${episode.name} (${episode.episode})"
    }
}
