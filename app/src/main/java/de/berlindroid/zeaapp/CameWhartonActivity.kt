package de.berlindroid.zeaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.fotoapparat.Fotoapparat
import io.fotoapparat.parameter.ScaleType
import io.fotoapparat.selector.back
import io.fotoapparat.view.CameraView

class CameWhartonActivity : AppCompatActivity() {

    lateinit var fotoapparat: Fotoapparat

    //TODO implement a call back for take a picture and always return a Jake Wharton picture instead
    //Because everyone is Jake Wharton at heart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.camewharton_activity)
        val cameraView = findViewById<CameraView>(R.id.camera_view)
        fotoapparat = Fotoapparat(
            context = this,
            view = cameraView,                   // view which will draw the camera preview
            scaleType = ScaleType.CenterCrop,    // (optional) we want the preview to fill the view
            lensPosition = back()               // (optional) we want back camera
        )
    }

    override fun onStart() {
        super.onStart()
        fotoapparat.start()
    }

    override fun onStop() {
        super.onStop()
        fotoapparat.stop()
    }


}