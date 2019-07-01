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
import android.util.Log
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.github.paolorotolo.appintro.AppIntroFragment
import com.github.paolorotolo.appintro.model.SliderPage
import de.berlindroid.zeaapp.api.GetPokemon
import de.berlindroid.zeaapp.api.PokeList
import de.berlindroid.zeaapp.api.ZeApppApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IamTheRealSplashActivity : AppIntro() {

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Note here that we DO NOT use setContentView();

        // Instead of fragments, you can also use our default slide.ground and image.
        // AppIntro will do the rest.
        var sliderPage = SliderPage()
        sliderPage.title = "That's going to be an awesome community app!"
        sliderPage.description = "< ADD AWESOME MOVIE QUOTE HERE >"
        sliderPage.imageDrawable = R.drawable.jw
        addSlide(AppIntroFragment.newInstance(sliderPage))

        repeat(9){i ->
            // ;)
            sliderPage = SliderPage()
            sliderPage.title = "And there is my favorite Deutsch artist :joy:"
            sliderPage.description = "< HOW MUCH IS THE FISHHHHH ${"?!".repeat(i)} >"
            sliderPage.imageDrawable = R.drawable.scooter
            addSlide(AppIntroFragment.newInstance(sliderPage))
        }

        sliderPage = SliderPage()
        sliderPage.title = "TROLL SOME MORE"
        sliderPage.description = "< HERE >"
        addSlide(AppIntroFragment.newInstance(sliderPage))

        sliderPage = SliderPage()
        sliderPage.title = "Plugging my twitter here"
        sliderPage.imageDrawable = R.drawable.ch
        sliderPage.description = "follow me on <REDACTED>"
        addSlide(AppIntroFragment.newInstance(sliderPage))

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"))
        setSeparatorColor(Color.parseColor("#2196F3"))

        isVibrateOn = true
        vibrateDuration = 500



       val api = App.pokeRetrofit.create(ZeApppApi::class.java)
        api.getPokemon().enqueue(object : Callback<GetPokemon> {
            override fun onFailure(call: Call<GetPokemon>, t: Throwable) {
                t.printStackTrace()
                Log.e("pokemon --->", t.toString())
            }

            override fun onResponse(call: Call<GetPokemon>, response: Response<GetPokemon>) {
                Log.d("pokemon --->",response.body()?.results.toString())
            }
        })

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        startActivity(Intent(this, MainActivity::class.java))
    }
}
