package com.example.riddlemiddle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.riddlemiddle.ui.theme.RiddleMiddleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RiddleMiddleTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    //Greeting("Android")
                    StartScreen()
                }
            }
        }
    }
}


@Composable
fun StartScreen(){
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
            .padding(top = 430.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            onClick = { /*TODO*/ }) {

            Text(text = "Daily Riddle",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    RiddleMiddleTheme(darkTheme = true) {
        StartScreen()
    }
}