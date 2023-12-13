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
fun RiddleAnswer(service: Firestore, nav: NavController) {
    Column {
        RiddleBox(type = "Explanation", headline = "The Three Gods", text = "Riddle Answer")
        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            onClick = { /*TODO*/ }) {

            Text(text = "New Riddle?",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }
    }

}