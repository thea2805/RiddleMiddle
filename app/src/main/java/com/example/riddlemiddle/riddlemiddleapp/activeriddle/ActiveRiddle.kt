package com.example.riddlemiddle.riddlemiddleapp.activeriddle


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riddlemiddle.apiService.KtorRiddleService
import com.example.riddlemiddle.apiService.model.Riddle
import com.example.riddlemiddle.riddlemiddleapp.firestore.service.Firestore
import com.example.riddlemiddle.riddlemiddleapp.riddletools.RiddleBox

@Composable
fun ActiveRiddle(service: Firestore, nav: NavController) {
    val riddleService = KtorRiddleService()
    val data = remember { mutableStateOf<List<Riddle>>(emptyList()) }
    val isLoading = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isLoading.value = true
        data.value = riddleService.get("")
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
    else{
        LazyColumn(modifier = Modifier
            .padding(vertical = 4.dp)) {
            items(data.value) { riddle ->
                DailyRiddle(riddle = riddle)
            }
        }

    }
}

@Composable
fun DailyRiddle(riddle: Riddle){
    var expanded by remember { mutableStateOf(false) }

    Column(
        Modifier
            .padding(10.dp)
            .width(400.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .background(Color(0xFF1B3474))
    ) {
        Text(text = riddle.title,
            Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.tertiary)

        Text(text = "Can you solve the riddle?",
            Modifier.padding(horizontal = 7.dp),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary)
        Text(text = riddle.question,
            Modifier.padding(horizontal = 7.dp),
            color = Color.White)

        if(expanded){
            Text(text = riddle.answer,
                Modifier.padding(horizontal = 7.dp),
                color = Color.White)
        }

        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            onClick = {expanded = !expanded}) {

            Text(text = "Answer?",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }
    }
}