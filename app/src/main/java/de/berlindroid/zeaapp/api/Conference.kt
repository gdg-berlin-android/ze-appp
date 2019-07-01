package de.berlindroid.zeaapp.api

data class Conference(
    val name: String,
    val place: String,
    val date: String,
    val cfp: Cfp,
    val url: String
)


data class Cfp(val from: String, val to: String, val url: String)