package com.example.mariosearch.data

import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {
    @GET("api/amiibo/?name=mario")
    suspend fun getCharactersList(): retrofit2.Response<AmiiboResponse>
}