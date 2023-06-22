package com.itxtest.rickandmorty.locationdetails.view

import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.business.model.domain.Location
import com.itxtest.rickandmorty.platform.base.view.BaseView

interface LocationDetailsView : BaseView {
    fun getLocationUrl(): String
    fun displayLocationData(location: Location, residents: List<Character>)
}
