package com.example.composehiltexample.domain.usecase

import com.example.composehiltexample.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repository: CharacterRepository) {

    operator fun invoke()=repository.getAllCharacters()
}