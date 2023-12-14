package com.example.riddlemiddle.navTest

sealed class Screens(val route : String) {
    object Start : Screens("StartScreen")
    object RiddleAnswer : Screens("RiddleAnswer")
    object Active : Screens("ActiveRiddle")
    object RiddleList : Screens("RiddleList")

}