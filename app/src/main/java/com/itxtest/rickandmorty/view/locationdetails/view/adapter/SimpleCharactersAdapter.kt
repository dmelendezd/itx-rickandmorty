package com.itxtest.rickandmorty.view.locationdetails.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itxtest.rickandmorty.R
import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.util.ImageLoadUtil
import com.itxtest.rickandmorty.databinding.SimpleCharacterItemBinding
import com.itxtest.rickandmorty.view.platform.extension.setMargins

class SimpleCharactersAdapter(
    private val residents: List<Character>,
    private val onCharacterClickCallback: (Character) -> Unit
) : RecyclerView.Adapter<SimpleCharactersAdapter.ResidentViewHolder>() {

    override fun getItemCount(): Int = residents.size

    override fun onBindViewHolder(holder: ResidentViewHolder, position: Int) {
        holder.bind(residents[position])
        val itemSeparation =
            holder.itemBinding.imageContainer.context.resources.getDimension(R.dimen.residents_list_item_separation).toInt()
        holder.itemBinding.imageContainer.setMargins(0, 0, 0, itemSeparation)
        holder.itemBinding.root.setOnClickListener { onCharacterClickCallback(residents[position]) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResidentViewHolder {
        return ResidentViewHolder(
            SimpleCharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class ResidentViewHolder(val itemBinding: SimpleCharacterItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(resident: Character) {
            itemBinding.name.text = resident.name
            ImageLoadUtil.load(resident.image, itemBinding.image)
        }
    }
}
