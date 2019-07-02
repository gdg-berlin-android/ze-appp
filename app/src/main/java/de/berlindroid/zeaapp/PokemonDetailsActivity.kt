package de.berlindroid.zeaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import de.berlindroid.zeaapp.api.PokeApi
import de.berlindroid.zeaapp.api.ZeApppApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonDetailsActivity : AppCompatActivity() {

    companion object {
        const val POKEMON_DETAILS_ACTIVITY_POKEMON_ID = "POKEMON_DETAILS_ACTIVITY_POKEMON_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)
        val id = intent?.getStringExtra(POKEMON_DETAILS_ACTIVITY_POKEMON_ID)
        val api = App.pokeRetrofit.create(PokeApi::class.java)

        GlobalScope.launch {
            val poke = api.getPokemonDetail(id!!)
            withContext(Dispatchers.Main){
                findViewById<TextView>(R.id.name).text = poke.name
                findViewById<TextView>(R.id.randomFact).text = poke.height

                val imageView = findViewById<ImageView>(R.id.pokeimage)
                val pokeImage = "https://img.pokemondb.net/sprites/black-white/anim/normal/${poke.name}.gif"
                Glide.with(this@PokemonDetailsActivity)
                    .load(pokeImage)
                    .into(imageView)

            }
        }
    }
}
