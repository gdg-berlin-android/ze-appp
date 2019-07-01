package de.berlindroid.zeaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView

class LuckySplashActivity : AppCompatActivity(), RandomizerInterface {

    override fun onRandomNumber(number: Int) {
        textView?.setText("${number}")
        if (number == 7 || number == 77 || number == 5 || (BuildConfig.DEBUG && counter++ == 10)) {
            startActivity(Intent(this, SplashActivity::class.java))
            randomizer.stop()
        }
    }

    private var counter: Int = 0
    var textView: TextView? = null

    val randomizer:Randomizer = Randomizer(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_splash)
        textView = findViewById(R.id.textView)
    }

    override fun onStart() {
        super.onStart()
        randomizer.start()
    }

    override fun onStop() {
        super.onStop()
        randomizer.stop()
    }


    class Randomizer(val listener: RandomizerInterface) {

        val handler = Handler(Looper.getMainLooper())

        val runnable  = Runnable {
            listener.onRandomNumber((Math.random() * 100).toInt())
            start()
        }

        fun start() {
           handler.postDelayed(runnable, 500)
        }

        fun stop() {
            handler.removeCallbacks(runnable)
        }

    }


}
