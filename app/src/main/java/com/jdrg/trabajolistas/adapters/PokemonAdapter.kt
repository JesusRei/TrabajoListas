package com.jdrg.trabajolistas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jdrg.trabajolistas.databinding.ItemPokemonBinding
import com.jdrg.trabajolistas.models.Pokemon

class PokemonAdapter(private val c: Context, private val datos: ArrayList<Pokemon>) :
    BaseAdapter() {

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(p0: Int): Any {
        return datos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: PokemonViewHolder
        val listItemView: View

        if (convertView == null) {
            val itemBinding = ItemPokemonBinding.inflate(LayoutInflater.from(c), parent, false)
            holder = PokemonViewHolder(itemBinding)
            listItemView = holder.view
            listItemView.tag = holder
        } else {
            listItemView = convertView
            holder = listItemView.tag as PokemonViewHolder
        }

        val pokemon = datos[position]

        holder.binding.textViewNamePokemon.text = pokemon.name
        holder.binding.textViewNumberPokemon.text = pokemon.number
        holder.binding.textViewTypePokemon.text = pokemon.type
        holder.binding.textViewNaturePokemon.text = pokemon.nature
        holder.binding.textViewSexPokemon.text = pokemon.sex
        holder.binding.textViewAbilityPokemon.text = pokemon.ability
        holder.binding.imageViewPokemon.setImageBitmap(pokemon.imagen)

        return listItemView
    }

    class PokemonViewHolder(itemBinding: ItemPokemonBinding) {
        var view: View = itemBinding.root
        var binding: ItemPokemonBinding = itemBinding
    }
}
