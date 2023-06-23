package com.itxtest.rickandmorty.characterslist.view.adapter

import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itxtest.rickandmorty.R
import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.databinding.CharacterItemBinding
import com.itxtest.rickandmorty.platform.app.ApplicationClass
import com.itxtest.rickandmorty.platform.extension.setBackgroundColorResource
import com.itxtest.rickandmorty.platform.extension.setMargins

class CharactersListAdapter(
    private val characters: MutableList<Character>
) : RecyclerView.Adapter<CharactersListAdapter.CharacterViewHolder>() {

    companion object {
        private const val STATUS_SEPARATOR = "-"
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])

        val resources = holder.itemBinding.root.context.resources
        val itemSeparation = resources.getDimension(R.dimen.characters_list_item_separation).toInt()
        holder.itemBinding.root.setMargins(itemSeparation, 0, 0, 0)

        if (resources.getBoolean(R.bool.characters_list_alternate_side_enabled)) {
            updateImageSide(holder.itemBinding, position)
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

    private fun updateImageSide(itemBinding: CharacterItemBinding, position: Int) {
        itemBinding.imageContainer.updateLayoutParams<ConstraintLayout.LayoutParams> {
            this.startToStart = ConstraintLayout.LayoutParams.UNSET
            this.endToEnd = ConstraintLayout.LayoutParams.UNSET
        }
        itemBinding.dataContainer.updateLayoutParams<ConstraintLayout.LayoutParams> {
            this.startToEnd = ConstraintLayout.LayoutParams.UNSET
            this.endToStart = ConstraintLayout.LayoutParams.UNSET
        }
        val constraintSet = ConstraintSet()
        constraintSet.clone(itemBinding.root)
        if (isImageLeftSide(position)) {
            constraintSet.connect(
                itemBinding.imageContainer.id,
                ConstraintSet.START,
                ConstraintSet.PARENT_ID,
                ConstraintSet.START
            )
            constraintSet.connect(
                itemBinding.dataContainer.id,
                ConstraintSet.START,
                itemBinding.imageContainer.id,
                ConstraintSet.END
            )
        } else {
            constraintSet.connect(
                itemBinding.imageContainer.id,
                ConstraintSet.END,
                ConstraintSet.PARENT_ID,
                ConstraintSet.END
            )
            constraintSet.connect(
                itemBinding.dataContainer.id,
                ConstraintSet.END,
                itemBinding.imageContainer.id,
                ConstraintSet.START
            )
            constraintSet.connect(
                itemBinding.dataContainer.id,
                ConstraintSet.START,
                ConstraintSet.PARENT_ID,
                ConstraintSet.START
            )
        }
        constraintSet.applyTo(itemBinding.root)
    }

    private fun isImageLeftSide(position: Int): Boolean = position % 2 == 0

    class CharacterViewHolder(
         val itemBinding: CharacterItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        private lateinit var bindedModel: Character

        fun bind(character: Character) {
            bindedModel = character
            updateName()
            updateStatusSpecies()
            updateLocations()
            loadImage()
        }

        private fun updateName() {
            itemBinding.name.text = bindedModel.name
        }

        private fun updateStatusSpecies() {
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

        private fun updateLocations() {
            itemBinding.lastKnowLocation.text = bindedModel.lastKnownLocation.name
            itemBinding.origin.text = bindedModel.origin.name
        }

        private fun loadImage() {
            Glide.with(itemBinding.root.context).load(bindedModel.image).into(itemBinding.image)
        }
    }
}
