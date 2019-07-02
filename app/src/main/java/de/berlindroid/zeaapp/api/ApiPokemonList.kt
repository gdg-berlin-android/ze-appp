package de.berlindroid.zeaapp.api

data class ApiPokemonSprites(val front_default:String)

data class ApiPokemonList(val name:String, val url:String, val sprites:ApiPokemonSprites)

data class ApiPokemon(val results:List<ApiPokemonList>)

data class ApiPokemonDetail(val name: String, val height: String, val types: List<PokemonTypeThing>)

data class PokemonTypeThing(val slot: Int, val type: TypeForReal)
data class TypeForReal(val name: String)