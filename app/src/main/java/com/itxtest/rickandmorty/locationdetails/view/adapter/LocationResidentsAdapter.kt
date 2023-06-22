package com.itxtest.rickandmorty.locationdetails.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itxtest.rickandmorty.R
import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.business.model.util.ImageLoadUtil
import com.itxtest.rickandmorty.databinding.ResidentItemBinding
import com.itxtest.rickandmorty.platform.extension.setMargins

class LocationResidentsAdapter(
    private val residents: List<Character>
) : RecyclerView.Adapter<LocationResidentsAdapter.ResidentViewHolder>() {

    override fun getItemCount(): Int = residents.size

    override fun onBindViewHolder(holder: ResidentViewHolder, position: Int) {
        holder.bind(residents[position])
        val itemSeparation =
            holder.itemBinding.imageContainer.context.resources.getDimension(R.dimen.residents_list_item_separation).toInt()
        holder.itemBinding.imageContainer.setMargins(0, 0, 0, itemSeparation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResidentViewHolder {
        return ResidentViewHolder(
            ResidentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class ResidentViewHolder(val itemBinding: ResidentItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(resident: Character) {
            itemBinding.name.text = resident.name
            ImageLoadUtil.load(resident.image, itemBinding.image)
        }
    }
}
