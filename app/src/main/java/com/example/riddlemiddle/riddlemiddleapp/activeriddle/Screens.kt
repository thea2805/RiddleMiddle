package com.example.riddlemiddle.riddlemiddleapp.activeriddle

sealed class Screens(val route : String) {
    object Start : Screens("StartScreen")
    object RiddleAnswer : Screens("RiddleAnswer")
    object Active : Screens("ActiveRiddle")
    object Settings : Screens("Settings")
    object RiddleList : Screens("RiddleList")
    object JokeList : Screens("JokeList")

}