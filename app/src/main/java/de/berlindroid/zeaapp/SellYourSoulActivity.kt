package de.berlindroid.zeaapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_sell_your_soul.*
import kotlinx.android.synthetic.main.content_sell_your_soul.*
import kotlinx.android.synthetic.main.webviewactivity.*

class SellYourSoulActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_your_soul)
        setSupportActionBar(toolbar)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        webView.loadUrl("file:///android_asset/www/index.html")
    }

}
