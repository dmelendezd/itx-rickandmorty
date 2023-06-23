package com.itxtest.rickandmorty.model.service.character

import com.itxtest.rickandmorty.model.service.base.BaseService
import com.itxtest.rickandmorty.model.service.base.RetrofitProvider
import com.itxtest.rickandmorty.model.service.constant.NetworkConstants
import com.itxtest.rickandmorty.model.domain.Character

class CharactersService(private val ids: List<Int>) : BaseService<List<Character>>() {

    private val uncachedCharacterIds = arrayListOf<Int>()

    init {
        resource = NetworkConstants.CHARACTERS_RESOURCE
    }

    override fun start() {
        val cachedCharacters = getCachedCharacters()
        if (cachedCharacters.isNotEmpty()) {
            onServiceSuccess(cachedCharacters)
        }
        if (uncachedCharacterIds.isNotEmpty()) {
            addResourceParameter(uncachedCharacterIds.toString())
            RetrofitProvider.apiService.getCharacters(requestUrl).enqueue(getCallback())
        }
    }

    private fun getCachedCharacters(): List<Character> {
        val validCachedCharacters = arrayListOf<Character>()
        ids.forEach { characterId ->
            val character = cacheManager.getCachedCharacter(characterId)
            if (character != null) {
                validCachedCharacters.add(character)
            } else {
                uncachedCharacterIds.add(characterId)
            }
        }
        return validCachedCharacters
    }
}
