package com.example.composehiltexample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composehiltexample.core.common.Resource
import com.example.composehiltexample.domain.usecase.GetAllCharactersUseCase
import com.example.composehiltexample.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase: GetAllCharactersUseCase): ViewModel() {

    private val _charactersState= MutableStateFlow(CharacterState())
    val charactersState:StateFlow<CharacterState>
        get() = _charactersState
    init {
        getAllCharacters()
    }

    private fun getAllCharacters(){
        useCase().onEach {
            when(it){
                is Resource.Error -> {
                    _charactersState.value=CharacterState().copy(errorMsg = it.msg)
                }
                is Resource.Loading -> {
                    _charactersState.value=CharacterState().copy(isLoading = true)
                }
                is Resource.Success -> {
                    _charactersState.value=CharacterState().copy(characters = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}