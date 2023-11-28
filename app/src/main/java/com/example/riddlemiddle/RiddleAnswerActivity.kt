package com.example.riddlemiddle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.riddlemiddle.riddlemiddleapp.riddletools.RiddleBox
import com.example.riddlemiddle.ui.theme.RiddleMiddleTheme

class RiddleAnswerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{

        }
    }
}


@Composable
fun RiddleAnswer() {
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







@Preview(showBackground = true)
@Composable
fun RiddleAnswerPreview() {
    RiddleMiddleTheme(darkTheme = true) {
        RiddleAnswer()
    }
}