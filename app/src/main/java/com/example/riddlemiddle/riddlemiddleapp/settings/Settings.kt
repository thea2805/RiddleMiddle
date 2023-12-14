package com.example.riddlemiddle.riddlemiddleapp.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riddlemiddle.R
import com.example.riddlemiddle.riddlemiddleapp.firestore.service.Firestore
import kotlinx.coroutines.launch

@Composable
// Function should take API input? This should be reusable, as both active riddle box + answer box
    fun Settings(service: Firestore, nav: NavController){

    // check if riddle/input exists when collecting from api, otherwise display the following

    val userEmail = service.getCurrentUser()
    val scope = rememberCoroutineScope()

    Column(
        Modifier
            .padding(10.dp)
            .width(400.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .background(Color(0xFF1B3474))
    ) {
        Image(
            painter = painterResource(id = R.drawable.tophat),
            contentDescription = "background tophat image",
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally))


        Text(text = "User Information",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp))

        Text(text = "Email: $userEmail",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .padding(horizontal = 20.dp))
        Text(text = "Completed Riddles: ???",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .padding(horizontal = 20.dp))

        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            onClick = {
                scope.launch {
                    service.SignOut()
                    nav.navigate("Login")
                }
            }) {

            Text(text = "Log Out",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }

    }
}
