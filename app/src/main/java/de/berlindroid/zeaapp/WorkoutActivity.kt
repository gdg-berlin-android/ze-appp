package de.berlindroid.zeaapp

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_workout.*
import kotlinx.android.synthetic.main.content_workout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WorkoutActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            launch {
                for (i in 1..250) {
                    workHarderLayout.setBackgroundColor(Color.valueOf(i.toFloat(), 0f, 0f).toArgb())
                    kotlinx.coroutines.delay(20)
                }

            }
        }
    }

}
