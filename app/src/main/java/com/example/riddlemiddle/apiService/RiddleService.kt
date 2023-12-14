package com.example.riddlemiddle.apiService

import com.example.riddlemiddle.apiService.model.Riddle
interface RiddleService {
    suspend fun get(): List<Riddle>
    suspend fun post(riddle: Riddle)
    suspend fun getby(title: String): List<Riddle>
}