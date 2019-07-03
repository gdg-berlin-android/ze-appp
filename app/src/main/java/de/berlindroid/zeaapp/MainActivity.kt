package de.berlindroid.zeaapp

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.plattysoft.leonids.ParticleSystem
import de.berlindroid.zeaapp.api.ApiPokemon
import de.berlindroid.zeaapp.api.PokeApi
import de.berlindroid.zeaapp.api.ZeApppApi
import de.berlindroid.zeaapp.emails.EmailActivity
import helloar.HelloArActivity
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
import kotlin.random.Random


fun Activity.createParticleEffect() {
    ParticleSystem(this, 1000, R.drawable.gdg_logo, 1000)
        .setSpeedRange(0.2f, 0.5f)
        .setAcceleration(1000F, 20)
        .emit(Random.nextInt(1000), Random.nextInt(1000), 100)

}

class MainActivity : AppCompatActivity(), View.OnClickListener, CoroutineScope {
    private lateinit var animator: ValueAnimator
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()
    var numberOfTaps: Int = 0

    private lateinit var buttons: List<Button>


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val isAnnoying = intent.getBooleanExtra("ANNOYING", true)

        workHarder.setOnClickListener {
            createParticleEffect()
            startActivity(Intent(this@MainActivity, WorkoutActivity::class.java))
        }

        balling_eights.setOnClickListener {
            createParticleEffect()
            startActivity(Intent(this@MainActivity, BallingActivity::class.java))
        }
        balling_eights.setOnLongClickListener {
            createParticleEffect()
            startActivity(Intent(this@MainActivity, SellYourSoulActivity::class.java))
            true
        }

        if (Math.random() >= 0.31415926535)
            Glide.with(this).load(R.drawable.clippy).into(clippy_container)

        initOnClickListeners()
        initRest()

        buttons = listOf(
            main_play_button,
            pokemonButton,
            conferenceButton,
            historyButton,
            whereAreChetAndRomain,
            balling_eights,
            tryToLottie,
            workHarder,
            idkBtn,
            italianButton
        )

        if (isAnnoying) {
            initButtonEnabledAnim()
        }

        main_text.setOnClickListener {
            createParticleEffect()
            numberOfTaps++
            when (numberOfTaps) {
                7 -> {
                    runEasterEgg()
                }
            }

        }

        jumpingButton.setOnClickListener {
            createParticleEffect()
            it.animate().rotationBy(15f).translationY(Math.random().toFloat() * 100)
                .translationX(Math.random().toFloat() * 100).setDuration(20).start()
        }

        jumpingButton.setOnLongClickListener {
            createParticleEffect()
            val intent = Intent(this, PaletteActivity::class.java)
            startActivity(intent)
            true
        }

        italianButton.setOnClickListener {
            createParticleEffect()
            val intent = Intent(this, AnimalActivity::class.java)
            startActivity(intent)
        }

        italianButton.setOnLongClickListener {

            createParticleEffect()
            val intent = Intent(this, HelloArActivity::class.java)
            startActivity(intent)
            true
        }

        pokemonButton.setOnClickListener {
            createParticleEffect()
            val api = App.pokeRetrofit.create(ZeApppApi::class.java)
            startActivity(Intent(this, PokemonActivity::class.java))
        }

        pokemonButton.setOnLongClickListener {
            createParticleEffect()
            val api = App.pokeRetrofit.create(PokeApi::class.java)

            newSchoolRequest()
            //oldSchoolRequest(api)
            true
        }

        conferenceButton.setOnClickListener {
            createParticleEffect()
            startActivity(Intent(applicationContext, EmailActivity::class.java))

        }

        historyButton.setOnClickListener {
            createParticleEffect()
            showModal()
        }

        historyButton.setOnLongClickListener() {
            createParticleEffect()
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

        big_red_button.setOnClickListener {
            Toast.makeText(
                this,
                "COME ON!!!!!! \nYou really need to work on your impulse",
                Toast.LENGTH_LONG
            ).show()
        }

        doSomthing.setOnClickListener {
            Toast.makeText(
                this,
                "I did it but won't tell you what it is...",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun initButtonEnabledAnim() {
        animator = ValueAnimator.ofInt(0, buttons.size)
        animator.duration = (1000 * buttons.size).toLong()
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
        animator.start()

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

    @SuppressLint("NewApi")
    private fun showModal() {
        val bottomSheetDialog = BottomSheetDialog(this, R.style.DayNightBottomSheetDialog)
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
        idkBtn?.setOnClickListener {
            val t = (Math.random() * 100).toInt()
            //TODO Fix the delay!!!
            for (i in 0..t) {
                if (i % 2 == 0) {
                    balling_eights.setVisibility(View.VISIBLE)
                } else {
                    balling_eights.visibility = View.INVISIBLE
                }
            }
            balling_eights?.performClick()
        }
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
