package com.itxtest.rickandmorty.view.characterslist.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itxtest.rickandmorty.R
import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.domain.Location
import com.itxtest.rickandmorty.model.util.ImageLoadUtil
import com.itxtest.rickandmorty.databinding.CharacterItemBinding
import com.itxtest.rickandmorty.view.platform.app.ApplicationClass
import com.itxtest.rickandmorty.view.platform.extension.setBackgroundColorResource
import com.itxtest.rickandmorty.view.platform.extension.setMargins

class CharactersListAdapter(
    private val adapterModel: CharactersAdapterModel
) : RecyclerView.Adapter<CharactersListAdapter.CharacterViewHolder>() {

    companion object {
        private const val STATUS_SEPARATOR = "-"
    }

    private val characters get() = adapterModel.characters

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        if (characters.indexOf(holder.bindedModel) == characters.lastIndex) {
            adapterModel.onLastItemVisibilityChangedCallback?.invoke(false)
        }

        val character = characters[position]
        holder.bind(character)
        val itemSeparation =
            holder.itemBinding.root.context.resources.getDimension(R.dimen.characters_list_item_separation).toInt()
        holder.itemBinding.root.setMargins(itemSeparation, 0, 0, 0)

        holder.itemBinding.lastKnowLocation.setOnClickListener {
            adapterModel.onLastKnownLocationClickCallback?.invoke(character.lastKnownLocation)
        }
        holder.itemBinding.origin.setOnClickListener {
            adapterModel.onOriginClickCallback?.invoke(character.origin)
        }
        holder.itemBinding.root.setOnClickListener {
            adapterModel.onCharacterNameClickCallback?.invoke(character)
        }

        if (position == characters.lastIndex) {
            adapterModel.onLastItemVisibilityChangedCallback?.invoke(true)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CharacterItemBinding.inflate(ApplicationClass.currentActivity.layoutInflater, parent, false)
        )
    }

    fun add(characters: List<Character>) {
        val firstPositionToAdd = itemCount
        var addedCount = 0
        characters.forEach {
            if (!this.characters.contains(it)) {
                this.characters.add(it)
                addedCount ++
            }
        }
        if (addedCount > 0) {
            notifyItemRangeInserted(firstPositionToAdd, addedCount)
        }
    }

    class CharacterViewHolder(
         val itemBinding: CharacterItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        var bindedModel: Character? = null

        fun bind(character: Character) {
            bindedModel = character
            updateName()
            updateStatusSpecies()
            updateLocations()
            loadImage()
        }

        private fun updateName() {
            itemBinding.name.text = bindedModel?.name
        }

        private fun updateStatusSpecies() {
            bindedModel?.let { bindedModel ->
                val speciesStatusText = "${bindedModel.status} $STATUS_SEPARATOR ${bindedModel.species}"
                itemBinding.speciesStatus.text = speciesStatusText

                itemBinding.statusIndicator.setBackgroundColorResource(
                    when {
                        bindedModel.isAlive() -> R.color.green
                        bindedModel.isDead() -> R.color.red
                        else -> R.color.dark_grey
                    }
                )
            }
        }

        private fun updateLocations() {
            itemBinding.lastKnowLocation.text = bindedModel?.lastKnownLocation?.name
            itemBinding.origin.text = bindedModel?.origin?.name
        }

        private fun loadImage() {
            bindedModel?.image?.let { ImageLoadUtil.load(it, itemBinding.image) }
        }
    }

    data class CharactersAdapterModel(
        val characters: MutableList<Character>,
        val onLastItemVisibilityChangedCallback: ((Boolean) -> Unit)? = null,
        val onLastKnownLocationClickCallback: ((Location) -> Unit)? = null,
        val onOriginClickCallback: ((Location) -> Unit)? = null,
        val onCharacterNameClickCallback: ((Character) -> Unit)? = null
    )
}
