package de.berlindroid.zeaapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.github.paolorotolo.appintro.AppIntro
import android.graphics.Color.parseColor
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.github.paolorotolo.appintro.AppIntroFragment
import com.github.paolorotolo.appintro.model.SliderPage



class IamTheRealSplashActivity : AppIntro() {

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Note here that we DO NOT use setContentView();

        // Instead of fragments, you can also use our default slide.
        // Just create a `SliderPage` and provide title, description, background and image.
        // AppIntro will do the rest.
        var sliderPage = SliderPage()
        sliderPage.title = "That's going to be an awesome community app!"
        sliderPage.description = "< ADD AWESOME MOVIE QUOTE HERE >"
        sliderPage.imageDrawable = R.drawable.jw
        addSlide(AppIntroFragment.newInstance(sliderPage))

        sliderPage = SliderPage()
        sliderPage.title = "And this is the awesom slide number 2"
        sliderPage.description = "< ADD AWESOME MOVIE QUOTE HERE >"
        sliderPage.imageDrawable = R.drawable.jw
        addSlide(AppIntroFragment.newInstance(sliderPage))

        sliderPage = SliderPage()
        sliderPage.title = "And this is the awesom slide number 3"
        sliderPage.description = "< ADD AWESOME MOVIE QUOTE HERE >"
        sliderPage.imageDrawable = R.drawable.jw
        addSlide(AppIntroFragment.newInstance(sliderPage))

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"))
        setSeparatorColor(Color.parseColor("#2196F3"))

        isVibrateOn = true
        vibrateDuration = 500
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        startActivity(Intent(this, SplashActivity::class.java))
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        startActivity(Intent(this, SplashActivity::class.java))
    }
}
