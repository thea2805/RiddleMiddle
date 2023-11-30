package com.example.riddlemiddle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.riddlemiddle.riddlemiddleapp.login.LoginForm
import com.example.riddlemiddle.ui.theme.RiddleMiddleTheme


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RiddleMiddleTheme(darkTheme = true) {
                LoginForm()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginActivityPreview() {
    RiddleMiddleTheme(darkTheme = true) {
        StartScreen()
    }
}