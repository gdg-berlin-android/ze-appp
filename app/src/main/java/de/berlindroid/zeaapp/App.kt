package de.berlindroid.zeaapp

import android.app.Application
import retrofit2.Retrofit

class App : Application() {

    companion object {
        val retrofit  = Retrofit.Builder().baseUrl("https://wrapapi.com/").build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}