package com.example.riddlemiddle.apiService

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.riddlemiddle.apiService.model.Riddle
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

const val baseUrlRiddle = "https://api.api-ninjas.com/v1/riddles"
const val ninjaApiKey = "FDM1Sd042Tv63SzFibDeuw==2iBlBqWroY5nCins"

class KtorRiddleService : RiddleService {
    private val client = HttpClient(Android){
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation){
            json(Json{
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(DefaultRequest){
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }

    override suspend fun get(): List<Riddle> {
        return try {
            client.get() {
                url(baseUrlRiddle)
                header("X-Api-Key", ninjaApiKey)
            }.body()
        }
        catch (e: Exception) {
            Log.v("RIDDLE_SERVICE", e.toString())
            emptyList()
        }
    }

    // Testing API - get Riddles

    /*
        val riddleService = KtorRiddleService()
        val data = remember { mutableStateOf<List<Riddle>>(emptyList()) }
        val isLoading = remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            isLoading.value = true
            data.value = riddleService.get()
            Log.d("GETTING_DATA", data.value.toString())
            isLoading.value = false
        }
        DisposableEffect(Unit) {
            onDispose {
                riddleService.close()
            }
        }

        if(isLoading.value){
            CircularProgressIndicator()
        }
        // else map the values to the given components
    */


    override suspend fun getby(title: String): List<Riddle> {
        TODO("Not yet implemented")
    }

    override suspend fun post(riddle: Riddle) {
        TODO("Not yet implemented")
    }

    fun close() {
        client.close()
    }

}