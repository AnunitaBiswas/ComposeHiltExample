package com.example.composehiltexample.data.mapper

import com.example.composehiltexample.data.dto.CharactersDto
import com.example.composehiltexample.domain.model.Characters

fun CharactersDto.toDomainCharacter():Characters {
    return Characters(actor, id, image, name)
}