package com.itxtest.rickandmorty.characterdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.business.model.util.ImageLoadUtil
import com.itxtest.rickandmorty.characterdetails.presenter.CharacterDetailsPresenter
import com.itxtest.rickandmorty.databinding.CharacterDetailsFragmentBinding
import com.itxtest.rickandmorty.locationdetails.view.adapter.SimpleCharactersAdapter
import com.itxtest.rickandmorty.platform.base.view.BaseOverlay

class CharacterDetailsOverlay : BaseOverlay(), CharacterDetailsView {

    private var _binding: CharacterDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: CharacterDetailsPresenter
    private lateinit var character: Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = CharacterDetailsPresenter(this)
    }

    override fun onCreateCustomView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CharacterDetailsFragmentBinding.inflate(inflater, container, false)
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

    override fun getCharacter(): Character = character

    override fun showCharacterName(characterName: String) {
        binding.characterName.text = characterName
    }

    override fun showCharacterImage(imageUrl: String) {
        ImageLoadUtil.load(imageUrl, binding.backgroundImage)
        ImageLoadUtil.load(imageUrl, binding.characterImage)
    }

    override fun showEpisodeName(episodeName: String) {
        binding.episode.text = episodeName
    }

    override fun showEpisodeAirDate(airDate: String) {
        binding.airDate.text = airDate
    }

    override fun showEpisodeCharacters(characters: List<Character>) {
        val adapter = SimpleCharactersAdapter(characters) {
            presenter.onOtherCharacterClicked(it)
        }
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.charactersList.layoutManager = layoutManager
        binding.charactersList.adapter = adapter
    }

    companion object {
        fun newInstance(character: Character): CharacterDetailsOverlay {
            return CharacterDetailsOverlay().apply {
                this.character = character
            }
        }
    }
}
