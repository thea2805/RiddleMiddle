package com.example.riddlemiddle.apiService.model
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Riddle(
    @SerialName("title") val title: String,
    @SerialName("question") val question: String,
    @SerialName("answer") val answer: String,
)