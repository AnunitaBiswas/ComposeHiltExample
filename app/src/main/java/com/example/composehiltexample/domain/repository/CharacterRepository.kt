package com.example.composehiltexample.domain.repository

import com.example.composehiltexample.core.common.Resource
import com.example.composehiltexample.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getAllCharacters():Flow<Resource<List<Characters>>>
}