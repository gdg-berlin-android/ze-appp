package de.berlindroid.zeaapp.api

data class PokeList(val name:String,val url:String)

data class GetPokemon(val results:List<PokeList>)