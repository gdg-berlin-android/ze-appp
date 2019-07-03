package de.berlindroid.zeaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide

class VersusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_versus)

        val pokemon1Name = intent.getStringExtra("pokemon1") ?: "bulbasaur"
        val pokemon2Name = intent.getStringExtra("pokemon2") ?: "pikachu"

        val pokemon1Image = "https://img.pokemondb.net/sprites/black-white/anim/normal/$pokemon1Name.gif"
        val pokemon2Image = "https://img.pokemondb.net/sprites/black-white/anim/normal/$pokemon2Name.gif"
        
        findViewById<TextView>(R.id.poke1name).text = pokemon1Name.capitalize()
        findViewById<TextView>(R.id.poke2name).text = pokemon2Name.capitalize()

        Glide.with(this).load(pokemon1Image).into(findViewById(R.id.poke1img))
        Glide.with(this).load(pokemon2Image).into(findViewById(R.id.poke2img))
    }
}
