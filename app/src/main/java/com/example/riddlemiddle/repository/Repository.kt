package com.example.riddlemiddle.repository
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riddlemiddle.apiService.KtorRiddleService
import com.example.riddlemiddle.apiService.model.Riddle
import kotlinx.coroutines.launch

class Repository(private val apiService: KtorRiddleService) {
    suspend fun getRiddles(): List<Riddle> {
        return apiService.getMany("")
    }
}

class RiddleViewModel(private val repository: Repository): ViewModel() {
    private val _riddles = mutableStateOf<List<Riddle>>(emptyList())
    val riddles: State<List<Riddle>> get() = _riddles

    init {
        viewModelScope.launch {
            _riddles.value = repository.getRiddles()
        }
    }
    fun getRiddleByTitle(riddleTitle: String): Riddle? {
        return _riddles.value.find {it.title == riddleTitle}
    }
}

