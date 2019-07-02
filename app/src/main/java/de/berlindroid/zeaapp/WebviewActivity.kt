package de.berlindroid.zeaapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.webviewactivity.*

class WebviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webviewactivity)
        val webView = findViewById<WebView>(R.id.webview)
        webview.settings.javaScriptEnabled = true
        webview.webViewClient = WebViewClient()
        webView.loadUrl("https://www.droidcon.de/schedule")
    }
}