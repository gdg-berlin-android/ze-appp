package de.berlindroid.zeaapp

import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.palette_activity.*

class PaletteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.palette_activity)

        new_image.setOnClickListener {

            Glide.with(this)
                .also { it.clear(preview) }
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .load("https://lorempixel.com/400/400/")
                .addListener(object : RequestListener<Bitmap> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Bitmap>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResourceReady(
                        resource: Bitmap?,
                        model: Any?,
                        target: Target<Bitmap>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        process(resource!!)
                        return false
                    }

                })
                .into(preview)
        }
    }

    private fun process(resource: Bitmap) {
        Palette.Builder(resource)
            .generate {
                if (it != null) {
                    arrayOf(
                        sw1,
                        sw2,
                        sw3,
                        sw4,
                        sw5,
                        sw6
                    ).zip(
                        arrayOf(
                            it.getLightMutedColor(0),
                            it.getLightVibrantColor(0),
                            it.getMutedColor(0),
                            it.getVibrantColor(0),
                            it.getDarkMutedColor(0),
                            it.getDarkVibrantColor(0)
                        )
                    ) { v, color ->
                        if (color != 0) v.background = ColorDrawable(color)
                    }
                }
            }
    }
}