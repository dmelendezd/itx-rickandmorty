package com.itxtest.rickandmorty.view.locationdetails.presenter

import com.itxtest.rickandmorty.model.domain.Location
import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.service.base.RequestObserver
import com.itxtest.rickandmorty.model.service.character.CharactersService
import com.itxtest.rickandmorty.model.service.location.LocationsService
import com.itxtest.rickandmorty.view.characterdetails.view.CharacterDetailsOverlay
import com.itxtest.rickandmorty.view.locationdetails.util.ResourceUrlUtil
import com.itxtest.rickandmorty.view.locationdetails.view.LocationDetailsView
import com.itxtest.rickandmorty.view.platform.base.presenter.BasePresenter

class LocationDetailsPresenter(private val view: LocationDetailsView) : BasePresenter() {

    override fun onViewInitialized() {
        val locationUrl = view.getLocationUrl()
        if (locationUrl.isNotEmpty()) {
            getLocationData(ResourceUrlUtil.getIdFromUrl(locationUrl))
        }
    }

    fun onOtherCharacterClicked(character: Character) {
        CharacterDetailsOverlay.newInstance(character).show()
    }

    private fun getLocationData(locationId: Int) {
        LocationsService(listOf(locationId)).subscribe(object : RequestObserver<List<Location>>() {
            override fun onSuccess(response: List<Location>) {
                if (response.isNotEmpty()) {
                    handleOnLocationLoaded(response[0])
                }
            }
        }).start()
    }

    private fun handleOnLocationLoaded(location: Location) {
        if (location.residents.isEmpty()) {
            view.displayLocationData(location, listOf())
        } else {
            val residentIds = location.residents.map { ResourceUrlUtil.getIdFromUrl(it) }
            CharactersService(residentIds).subscribe(object : RequestObserver<List<Character>>() {
                override fun onSuccess(response: List<Character>) {
                    view.displayLocationData(location, response)
                }
            }).start()
        }
    }
}
