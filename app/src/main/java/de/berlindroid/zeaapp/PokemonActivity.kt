package de.berlindroid.zeaapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import de.berlindroid.zeaapp.pokecycler.Pokedapter
import de.berlindroid.zeaapp.pokecycler.Pokemon
import kotlinx.android.synthetic.main.pokemon_layout.*

class PokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_layout)
        val adapter = Pokedapter()
        pokemonRecyclerView.adapter = adapter
        adapter.pokemons.add(Pokemon.mock())
    }
}