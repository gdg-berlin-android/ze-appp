package de.berlindroid.zeaapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import de.berlindroid.zeaapp.api.ApiPokemon
import de.berlindroid.zeaapp.api.ZeApppApi
import de.berlindroid.zeaapp.pokecycler.Pokedapter
import de.berlindroid.zeaapp.pokecycler.Pokemon
import kotlinx.android.synthetic.main.pokemon_layout.*
import okhttp3.HttpUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.poke_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.sort -> {
                // todo: sort the pokelist, pleaseee.
                true
            }
            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_layout)
        val adapter = Pokedapter()
        pokemonRecyclerView.adapter = adapter

        val api = App.pokeRetrofit.create(ZeApppApi::class.java)

        api.getPokemon().enqueue(object : Callback<ApiPokemon> {
            override fun onFailure(call: Call<ApiPokemon>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(
                    this@PokemonActivity,
                    "pokemon ---> $t",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(call: Call<ApiPokemon>, response: Response<ApiPokemon>) {
                val pokemon = response.body()!!.results.map {
                    Pokemon(
                        HttpUrl.parse(it.url)?.pathSegments()?.lastButOne()!!,
                        it.name,
                        it.url
                    )
                }

                Glide.with(this@PokemonActivity.applicationContext)
                    .load("https://img.pokemondb.net/sprites/black-white/anim/normal/${pokemon.random().name}.gif")
                    .into(header)

                Log.d(PokemonActivity::class.java.simpleName, "Pokemon $pokemon")
                adapter.pokemons.addAll(pokemon)
                adapter.notifyDataSetChanged()
            }

            private fun <T> List<T>.lastButOne(): T {
                // TODO: Does this actually work?
                // IT DOES, TESTED IN PRODUCTION
                return this[this.size -2]
            }
        })
    }
}