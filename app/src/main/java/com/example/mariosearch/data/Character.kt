package com.example.mariosearch.data

data class AmiiboResponse(
    val amiibo: List<Character>?
)

data class Character(
    val image: String?,
    val name: String?,
    val gameSeries: String?
)