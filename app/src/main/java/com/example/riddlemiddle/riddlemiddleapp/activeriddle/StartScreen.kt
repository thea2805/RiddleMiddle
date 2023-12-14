package com.example.riddlemiddle.riddlemiddleapp.activeriddle

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riddlemiddle.R
import com.example.riddlemiddle.riddlemiddleapp.firestore.service.Firestore


@Composable
fun StartScreen(service: Firestore, nav: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ){
        Image(
            painter = painterResource(id = R.drawable.tophat),
            contentDescription = "background tophat image",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
                .padding(bottom = 25.dp))
        Row (modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 50.dp))
        {
            Text(text = "R",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.secondary)
            Text(text = "i",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.tertiary)
            Text(text = "ddle M",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.secondary)
            Text(text = "i",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.tertiary)
            Text(text = "ddle",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.secondary)
        }

        Button(modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 390.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            onClick = { nav.navigate("ActiveRiddle") }) {

            Text(text = "Daily Riddle",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }

    }
}
