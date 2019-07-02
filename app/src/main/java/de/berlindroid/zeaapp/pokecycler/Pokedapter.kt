package de.berlindroid.zeaapp.pokecycler

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.TooltipCompat
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.berlindroid.zeaapp.PokemonDetailsActivity
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
        val view = holder.itemView
        ViewCompat.setAccessibilityDelegate(view, PokeAccessibilityDelegate())
        TooltipCompat.setTooltipText(view, view.toastText())
    }

}

data class Pokemon(
    val id: String,
    val name: String,
    val url: String
)

class Pokeholder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(pokemon: Pokemon) {
        itemView.pokeName.text = pokemon.name.capitalize()

//        val pokeImage = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.id}.png"
        val pokeImage = "https://img.pokemondb.net/sprites/black-white/anim/normal/${pokemon.name}.gif"
        Glide.with(itemView.context).load(pokeImage).into(itemView.pokeImage)

        itemView.setOnClickListener {
            Toast.makeText(it.context, pokemon.url, Toast.LENGTH_LONG).show();
        }

        itemView.setOnClickListener {
            // Open details hacky way: PokemonDetailsActivity
            val intent = Intent(itemView.context, PokemonDetailsActivity::class.java)
            intent.putExtra(PokemonDetailsActivity.POKEMON_DETAILS_ACTIVITY_POKEMON_ID, pokemon.id)
            itemView.context.startActivity(intent)
        }
    }
}

private fun View?.toastText(): CharSequence {
    return (this?.findViewById<TextView>(R.id.pokeName))?.text ?: "Not a TextView"
}

private const val ACTION_TOAST_NAME = 348732

class PokeAccessibilityDelegate : AccessibilityDelegateCompat() {

    override fun onInitializeAccessibilityNodeInfo(
        host: View?,
        info: AccessibilityNodeInfoCompat?
    ) {
        super.onInitializeAccessibilityNodeInfo(host, info)
        AccessibilityNodeInfoCompat.AccessibilityActionCompat(
            ACTION_TOAST_NAME,
            "Toast ${host.toastText()}"
        )
        info?.addAction(ACTION_TOAST_NAME)
    }


    override fun performAccessibilityAction(host: View?, action: Int, args: Bundle?): Boolean {
        return when (action) {
            ACTION_TOAST_NAME -> {
                host?.let {
                    toast(it, host.toastText().toString())
                }
                true
            }
            else -> super.performAccessibilityAction(host, action, args)
        }
    }

    private fun toast(view: View, message: String) {
        toast?.cancel()
        Toast.makeText(view.context, message, Toast.LENGTH_SHORT).apply {
            toast = this
            show()
        }
    }

    companion object {
        private var toast: Toast? = null
    }
}
