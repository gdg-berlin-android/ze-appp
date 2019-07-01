package de.berlindroid.zeaapp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import de.berlindroid.zeaapp.api.GetPokemon
import de.berlindroid.zeaapp.api.ZeApppApi
import de.berlindroid.zeaapp.pokecycler.Pokedapter
import de.berlindroid.zeaapp.pokecycler.Pokemon
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pokemon_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_layout)
        val adapter = Pokedapter()
        pokemonRecyclerView.adapter = adapter

        val api = App.pokeRetrofit.create(ZeApppApi::class.java)

        api.getPokemon().enqueue(object : Callback<GetPokemon> {
            override fun onFailure(call: Call<GetPokemon>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(
                    this@PokemonActivity,
                    "pokemon ---> $t",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(call: Call<GetPokemon>, response: Response<GetPokemon>) {
                val pokemon = response.body()!!.results.map { Pokemon(it.name) }
                Log.d(PokemonActivity::class.java.simpleName,"Pokemon $pokemon")
                adapter.pokemons.addAll(pokemon)
                adapter.notifyDataSetChanged()
            }
        })
    }
}