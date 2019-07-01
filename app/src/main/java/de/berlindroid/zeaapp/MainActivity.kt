package de.berlindroid.zeaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import de.berlindroid.zeaapp.api.ZeApppApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListener()
//        App.retrofit.create(ZeApppApi.javaClass).
    }

    private fun setupListener() {
        main_play_button.setOnClickListener {
            Snackbar.make(main_container, getString(R.string.main_lose_text), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.main_lose_action)) {
                    Toast.makeText(this, getString(R.string.main_baby_loser), Toast.LENGTH_LONG).show()
                    finish()
                }
                .show()
        }
        main_play_button.setOnLongClickListener {
            Snackbar.make(main_container, getString(R.string.main_zin), Snackbar.LENGTH_LONG).show()
            true
        }
    }
}
