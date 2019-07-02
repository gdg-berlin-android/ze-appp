package de.berlindroid.zeaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.berlindroid.zeaapp.api.PokeApi
import de.berlindroid.zeaapp.api.ZeApppApi

class PokemonDetailsActivity : AppCompatActivity() {

    companion object {
        const val POKEMON_DETAILS_ACTIVITY_POKEMON_ID = "POKEMON_DETAILS_ACTIVITY_POKEMON_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)
        val id = intent?.getStringExtra(POKEMON_DETAILS_ACTIVITY_POKEMON_ID)
        val api = App.pokeRetrofit.create(PokeApi::class.java)
        //TODO: to implement
        //
    }
}
