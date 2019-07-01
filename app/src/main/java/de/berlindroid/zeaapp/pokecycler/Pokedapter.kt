package de.berlindroid.zeaapp.pokecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.berlindroid.zeaapp.R
import kotlinx.android.synthetic.main.item_pokemon.view.*

class Pokedapter : RecyclerView.Adapter<Pokeholder>() {

    val pokemons = mutableListOf<Pokemon>()

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pokeholder {
// TODO: do the layout please
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return Pokeholder(view)
    }

    override fun onBindViewHolder(holder: Pokeholder, position: Int) {
        holder.bind(pokemons[position])
    }

}

data class Pokemon(
    val name: String
)

class Pokeholder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(pokemon: Pokemon) {
        itemView.pokeName.text = pokemon.name
    }
}