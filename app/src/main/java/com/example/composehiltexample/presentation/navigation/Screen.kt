package com.example.composehiltexample.presentation.navigation

sealed class Screen(val route:String){
    object CharacterScreen:Screen("character_screen")
}
