package com.itxtest.rickandmorty.model.service.episode

import com.itxtest.rickandmorty.model.service.base.BaseService
import com.itxtest.rickandmorty.model.service.base.RetrofitProvider
import com.itxtest.rickandmorty.model.service.constant.NetworkConstants
import com.itxtest.rickandmorty.model.domain.Episode

class EpisodesService(private val ids: List<Int>) : BaseService<List<Episode>>() {

    private val uncachedEpisodesIds = arrayListOf<Int>()

    init {
        resource = NetworkConstants.EPISODE_RESOURCE
    }

    override fun start() {
        val cachedEpisodes = getCachedEpisodes()
        if (cachedEpisodes.isNotEmpty()) {
            onServiceSuccess(cachedEpisodes)
        }
        if (uncachedEpisodesIds.isNotEmpty()) {
            addResourceParameter(uncachedEpisodesIds.toString())
            RetrofitProvider.apiService.getEpisodes(requestUrl).enqueue(getCallback())
        }
    }

    private fun getCachedEpisodes(): List<Episode> {
        val validCachedEpisodes = arrayListOf<Episode>()
        ids.forEach { episodeId ->
            val episode = cacheManager.getCachedEpisode(episodeId)
            if (episode != null) {
                validCachedEpisodes.add(episode)
            } else {
                uncachedEpisodesIds.add(episodeId)
            }
        }
        return validCachedEpisodes
    }
}
