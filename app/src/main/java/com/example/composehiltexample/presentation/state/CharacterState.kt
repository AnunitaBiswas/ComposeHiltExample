package com.example.composehiltexample.presentation.state

import com.example.composehiltexample.domain.model.Characters

data class CharacterState(
    val characters:List<Characters>?= emptyList(),
    val errorMsg:String?="",
    val isLoading:Boolean=false
)
