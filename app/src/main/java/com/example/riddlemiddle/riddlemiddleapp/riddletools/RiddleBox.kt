package com.example.riddlemiddle.riddlemiddleapp.riddletools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
// Function should take API input? This should be reusable, as both active riddle box + answer box
fun RiddleBox(type: String, headline: String, text: String){
// check if riddle/input exists when collecting from api, otherwise display the following

    Column(
        Modifier
            .padding(10.dp)
            .width(400.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .background(Color(0xFF1B3474))
            ) {
        Text(text = headline,
            Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.tertiary)

        if(type == "Riddle"){
            Text(text = "Can you solve the riddle?",
                Modifier.padding(horizontal = 7.dp),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.tertiary)
            Text(text = text,
                Modifier.padding(horizontal = 7.dp),
                color = Color.White)
        }
        else {
            Text(text = "Explanation: ",
                Modifier.padding(horizontal = 7.dp),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.tertiary)
            Text(text = text,
                Modifier.padding(horizontal = 7.dp),
                color = Color.White)
        }


    }
}

@Preview
@Composable
fun RiddleBoxPreview(){
    RiddleBox(type = "Riddle",headline = "The Three Gods", text = "You and your team has com to an alien planet. The only way off is to appease its three alien overlords, Tee, Eff and Arr, by giving them the correct artifact..." )
}