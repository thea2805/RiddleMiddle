package com.example.riddlemiddle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.riddlemiddle.riddlemiddleapp.firestore.service.Firestore
import com.example.riddlemiddle.ui.theme.RiddleMiddleTheme
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.riddlemiddle.riddlemiddleapp.activeriddle.ActiveRiddle
import com.example.riddlemiddle.riddlemiddleapp.activeriddle.RiddleAnswer
import com.example.riddlemiddle.riddlemiddleapp.activeriddle.StartScreen
import com.example.riddlemiddle.riddlemiddleapp.login.LoginForm


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val auth = Firebase.auth
        FirebaseApp.initializeApp(this)
        val db = FirebaseFirestore.getInstance()
        val service = Firestore(db, auth)


        setContent {
            RiddleMiddleTheme(darkTheme = true) {
                val navController = rememberNavController()
                var startingScreen = "Login"
                if(Firebase.auth.currentUser != null)
                    {startingScreen = "StartScreen"}

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    NavHost(navController = navController, startDestination = startingScreen){
                        composable("Login") {LoginForm(service, nav = navController)}
                        composable("StartScreen") { StartScreen(service, nav = navController)}
                        composable("RiddleAnswer" ) { RiddleAnswer(service, nav = navController)}
                        composable("ActiveRiddle" ) { ActiveRiddle(service, nav = navController) }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    RiddleMiddleTheme(darkTheme = true) {
        //StartScreen()
    }
}