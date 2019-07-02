package de.berlindroid.zeaapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LogoActivity : AppCompatActivity(R.layout.activity_logo) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            delay(2000)
            startActivity(
                Intent(
                    this@LogoActivity,
                    IamTheRealSplashActivity::class.java
                )
            )
        }

    }
}