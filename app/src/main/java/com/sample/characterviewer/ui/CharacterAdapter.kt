package com.sample.characterviewer.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.characterviewer.R
import com.sample.characterviewer.databinding.ItemCharacterBinding
import com.sample.characterviewer.model.RelatedTopicModel

class CharacterAdapter(var character:List<RelatedTopicModel>): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var onItemClick: ((RelatedTopicModel)-> Unit)?=null

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemCharacterBinding.bind(view)

        fun handleData(item: RelatedTopicModel?) {
            item?.let {
                binding.itemCharacterTitle.text = item?.text?.split(" - ")?.get(0)!!
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =character.size?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(character?.get(position))
        holder.itemView.setOnClickListener {
            character?.get(position)?.let{
                onItemClick?.invoke(it)
            }
        }
    }
    fun updateData(filteredCharacters:List<RelatedTopicModel>) {
        character = filteredCharacters
        notifyDataSetChanged()
    }

}