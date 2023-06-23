package com.itxtest.rickandmorty.view.locationdetails.view

import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.domain.Location
import com.itxtest.rickandmorty.view.platform.base.view.BaseView

interface LocationDetailsView : BaseView {
    fun getLocationUrl(): String
    fun displayLocationData(location: Location, residents: List<Character>)
}
