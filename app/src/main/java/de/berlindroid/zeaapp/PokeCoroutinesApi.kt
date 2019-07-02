package de.berlindroid.zeaapp

import de.berlindroid.zeaapp.api.ApiPokemon
import retrofit2.http.GET

interface KPokeApi {

    @GET("api/v2/pokemon/?limit=999")
    suspend fun getPokemon(): ApiPokemon
}