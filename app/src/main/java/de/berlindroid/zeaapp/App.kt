package de.berlindroid.zeaapp

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class App : Application() {

    companion object {
        val retrofit  = Retrofit.Builder()
            .baseUrl("https://wrapapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}