package com.example.riddlemiddle.riddlemiddleapp.firestore.service

data class Riddle(
    val id:String,
    val title:String,
    val riddle:String,
    val answer:String)