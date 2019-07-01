package de.berlindroid.zeaapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import io.reactivex.Completable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageView : ImageView = findViewById(R.id.splash_image)

        Glide.with(this)
            .load(R.raw.nyan)
            .into(imageView)


        GlobalScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity,
                IamTheRealSplashActivity::class.java))
        }
    }
}
