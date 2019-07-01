package de.berlindroid.zeaapp.pokecycler

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
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.berlindroid.zeaapp.R
import kotlinx.android.synthetic.main.item_pokemon.view.*
import java.lang.RuntimeException

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
        var view = holder.itemView
        ViewCompat.setAccessibilityDelegate(view, PokeAccessibilityDelegate())
        TooltipCompat.setTooltipText(view, view.toastText())
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
        AccessibilityNodeInfoCompat.AccessibilityActionCompat(ACTION_TOAST_NAME, "Toast ${host.toastText()}")
        info?.addAction(ACTION_TOAST_NAME)
    }



    override fun performAccessibilityAction(host: View?, action: Int, args: Bundle?): Boolean {
        return when (action) {
            ACTION_TOAST_NAME -> {
                host?.let{
                    toast(it, host.toastText().toString())
                }
                true
            }
            else -> super.performAccessibilityAction(host, action, args)
        }
    }

    private fun toast(view:View, message:String) {
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
