package de.berlindroid.zeaapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import de.berlindroid.zeaapp.api.ApiPokemon
import de.berlindroid.zeaapp.api.PokeApi
import de.berlindroid.zeaapp.api.ZeApppApi
import de.berlindroid.zeaapp.emails.EmailActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalTime
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), View.OnClickListener, CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()
    var numberOfTaps: Int = 0


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initOnClickListeners()
        initRest()

        main_text.setOnClickListener {
            numberOfTaps++
            when (numberOfTaps) {
                7 -> {
                    runEasterEgg()
                }
            }

        }

        jumpingButton.setOnClickListener {
            it.animate().translationY(Math.random().toFloat() * 100).translationX(Math.random().toFloat() * 100).setDuration(20).start()
        }

        italianButton.setOnClickListener {
            val intent = Intent(this, AnimalActivity::class.java)
            startActivity(intent)
        }

        pokemonButton.setOnClickListener {
            val api = App.pokeRetrofit.create(ZeApppApi::class.java)
            startActivity(Intent(this, PokemonActivity::class.java))
        }

        pokemonButton.setOnLongClickListener {
            val api = App.pokeRetrofit.create(PokeApi::class.java)

            newSchoolRequest()
            //oldSchoolRequest(api)
            true
        }

        conferenceButton.setOnClickListener {
            startActivity(Intent(applicationContext, EmailActivity::class.java))

        }

        historyButton.setOnClickListener {
            showModal()
        }

        historyButton.setOnLongClickListener() {
            // TODO add actual time here
            val time = LocalTime.now()
            main_text.text = "The time is: $time"
            true
        }

        findViewById<Button>(R.id.whereAreChetAndRomain).setOnClickListener {
            startActivity(Intent(this, WhereAreChetAndRomainActivity::class.java))
        }

        findViewById<Button>(R.id.tryToLottie).setOnClickListener {
            startActivity(Intent(this, AnimateMeEverywhere::class.java))
        }
    }

    private fun newSchoolRequest() {
        val kApi = App.pokeRetrofit.create(KPokeApi::class.java)

        launch {
            try {
                val response = kApi.getPokemon()
                withContext(Main) {
                    //response.results
                    main_text.text = response.results?.joinToString { it.name }
                }
            } catch (e: Exception) {
                withContext(Main) {
                    main_text.text = "Failed to load pokemons"
                }
                Log.e("something", "MESSAGE", e)
            }
        }
    }

    private fun oldSchoolRequest(api: PokeApi) {
        api.getPokemon().enqueue(object : Callback<ApiPokemon> {
            override fun onFailure(call: Call<ApiPokemon>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(this@MainActivity, "pokemon ---> ${t.toString()}", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<ApiPokemon>, response: Response<ApiPokemon>) {
                runOnUiThread {
                    main_text.text = response.body()?.results?.joinToString { it.name }
                }
            }
        })
    }

    private fun showModal() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val sheetView = layoutInflater.inflate(R.layout.conference_modal_dialog, null)
        sheetView.findViewById<View>(R.id.shutAppContainer).setOnClickListener {
            Toast.makeText(this@MainActivity, "Bye Bye", Toast.LENGTH_LONG).show()
            this.finishAffinity()
        }
        sheetView.findViewById<View>(R.id.timerContainer).setOnClickListener {
            bottomSheetDialog.dismiss()
            val time = LocalTime.now()
            main_text.text = "The time is: $time"
        }
        sheetView.findViewById<View>(R.id.containerRedirecting).setOnClickListener {
            startActivity(Intent(this@MainActivity, WebviewActivity::class.java))
        }
        bottomSheetDialog.setContentView(sheetView)
        bottomSheetDialog.show()

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

    fun runEasterEgg() {
        //Reset the number of taps
        numberOfTaps = 0
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Easter Egg")
        builder.setMessage("Lauch Easter Egg?")
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
            //Someone else put something here
        })
        builder.setNegativeButton("Na", DialogInterface.OnClickListener { dialogInterface, i ->
            dialogInterface.dismiss()
        })
        builder.show()
    }
}
