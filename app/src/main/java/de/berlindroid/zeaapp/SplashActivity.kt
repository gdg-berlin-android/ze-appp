package de.berlindroid.zeaapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageView : ImageView = findViewById(R.id.splash_image)

        Glide.with(this)
            .load(R.raw.nyan)
            .into(imageView)
    }
}
