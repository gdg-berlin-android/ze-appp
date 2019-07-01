package de.berlindroid.zeaapp.api

data class ApiPokemonSprites(val front_default:String)

data class ApiPokemonList(val name:String, val url:String, val sprites:ApiPokemonSprites)

data class ApiPokemon(val results:List<ApiPokemonList>)