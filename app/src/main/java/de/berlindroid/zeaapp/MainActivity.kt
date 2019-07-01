package de.berlindroid.zeaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import de.berlindroid.zeaapp.Emails.EmailActivity
import de.berlindroid.zeaapp.api.GetPokemon
import de.berlindroid.zeaapp.api.PokeApi
import de.berlindroid.zeaapp.api.ZeApppApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initOnClickListeners()
        initRest()

        italianButton.setOnClickListener {
            val intent = Intent(this, AnimalActivity::class.java)
            startActivity(intent)
        }

        pokemonButton.setOnClickListener {
            val api = App.pokeRetrofit.create(ZeApppApi::class.java)
            startActivity(Intent(this, PokemonActivity::class.java))
        }

        conferenceButton.setOnClickListener {
            startActivity(Intent(applicationContext, EmailActivity::class.java))

        }
    }

    private fun initOnClickListeners() {
        main_play_button?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.main_play_button -> {
                Snackbar.make(
                    main_container,
                    getString(R.string.main_lose_text),
                    Snackbar.LENGTH_LONG
                )
                    .setAction(getString(R.string.main_lose_action)) {
                        Toast.makeText(this, getString(R.string.main_baby_loser), Toast.LENGTH_LONG)
                            .show()
                        finish()
                    }
                    .show()
            }
        }
    }


    fun initRest() {

    }
}
