package com.example.riddlemiddle.riddlemiddleapp.riddletools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
// Function should take API input? This should be reusable, as both active riddle box + answer box
fun RiddleBox(type: String, headline: String, text: String, ){
// check if riddle/input exists when collecting from api, otherwise display the following

}

@Preview
@Composable
fun RiddleBoxPreview(){
    RiddleBox(type = "Riddle",headline = "The Three Gods", text = "You and your team has com to an alien planet. The only way off is to appease its three alien overlords, Tee, Eff and Arr, by giving them the correct artifact..." )
}