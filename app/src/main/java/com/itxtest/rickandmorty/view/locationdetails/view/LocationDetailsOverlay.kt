package com.itxtest.rickandmorty.view.locationdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.domain.Location
import com.itxtest.rickandmorty.databinding.LocationDetailsFragmentBinding
import com.itxtest.rickandmorty.view.locationdetails.presenter.LocationDetailsPresenter
import com.itxtest.rickandmorty.view.locationdetails.view.adapter.SimpleCharactersAdapter
import com.itxtest.rickandmorty.view.platform.base.view.BaseOverlay

class LocationDetailsOverlay : BaseOverlay(), LocationDetailsView {

    private var _binding: LocationDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: LocationDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LocationDetailsPresenter(this)
    }

    override fun onCreateCustomView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LocationDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewInitialized()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getLocationUrl(): String {
        return arguments?.getString(LOCATION_URL_KEY) ?: ""
    }

    override fun displayLocationData(location: Location, residents: List<Character>) {
        initLocationTexts(location)
        initResidentsList(residents)
    }

    private fun initLocationTexts(location: Location) {
        binding.locationName.text = location.name
        binding.locationType.text = location.type
        binding.dimension.text = location.dimension
    }

    private fun initResidentsList(residents: List<Character>) {
        val adapter = SimpleCharactersAdapter(residents) {
            presenter.onOtherCharacterClicked(it)
        }
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.residentsList.layoutManager = layoutManager
        binding.residentsList.adapter = adapter
    }

    companion object {
        private const val LOCATION_URL_KEY = "locationUrl"

        fun newInstance(locationUrl: String): LocationDetailsOverlay {
            return LocationDetailsOverlay().apply {
                arguments = Bundle().apply { putString(LOCATION_URL_KEY, locationUrl) }
            }
        }
    }
}
