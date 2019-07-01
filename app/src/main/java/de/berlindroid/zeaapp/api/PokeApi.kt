package de.berlindroid.zeaapp.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface PokeApi {

    companion object {
        const val API_KEY = "7UF1tvyFxs4TXQDYq4btuIIfIuHvbSdz"
    }

    /**
     * "name": "Droidcon",
    "place": "Berlin, Germany",
    "date": "2019-07-01",
    "cfp": {
    "from": "2018-10-29",
    "to": "2019-04-30",
    "url": "https://sessionize.com/droidcon-berlin-2019/"
    },
    "url": "https://www.de.droidcon.com/"

     */
    @POST("use/mariobodemann/conferences/android/latest")
    fun latestAndroidConference(@Field("wrapAPIKey") key: String): Conference


    @GET("api/v2/pokemon/?limit=999")
    fun getPokemon(): Call<ApiPokemon>

}

// curl -X POST -d 'wrapAPIKey=7UF1tvyFxs4TXQDYq4btuIIfIuHvbSdz' https://wrapapi.com/use/mariobodemann/conferences/android/latest
