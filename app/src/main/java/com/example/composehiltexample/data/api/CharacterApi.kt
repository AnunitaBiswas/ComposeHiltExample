package com.example.composehiltexample.data.api

import com.example.composehiltexample.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getAllCharacters(): List<CharactersDto>
}