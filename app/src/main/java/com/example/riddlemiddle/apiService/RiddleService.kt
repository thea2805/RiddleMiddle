package com.example.riddlemiddle.apiService

import com.example.riddlemiddle.apiService.model.Riddle
interface RiddleService {
    suspend fun get(url: String?): List<Riddle>
    suspend fun getMany(url: String?): List<Riddle>
}