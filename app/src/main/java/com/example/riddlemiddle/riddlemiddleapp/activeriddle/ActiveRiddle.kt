package com.example.riddlemiddle.riddlemiddleapp.activeriddle


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.riddlemiddle.riddlemiddleapp.firestore.service.Firestore
import com.example.riddlemiddle.riddlemiddleapp.riddletools.RiddleBox

@Composable
fun ActiveRiddle(service: Firestore, nav: NavController) {
    Column {
        RiddleBox(type = "Riddle", headline = "Headline", text = "RiddleText")
        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            onClick = { nav.navigate("RiddleAnswer") }) {

            Text(text = "Answer?",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }
    }



}