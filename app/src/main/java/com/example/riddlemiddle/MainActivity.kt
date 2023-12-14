package com.example.riddlemiddle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.riddlemiddle.navTest.Screens
import com.example.riddlemiddle.riddlemiddleapp.activeriddle.ActiveRiddle
import com.example.riddlemiddle.riddlemiddleapp.activeriddle.RiddleAnswer
import com.example.riddlemiddle.riddlemiddleapp.activeriddle.StartScreen
import com.example.riddlemiddle.riddlemiddleapp.login.LoginForm
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                                NavigationBarItem(
                                    selected = navigationItem.route == currentDestination?.route,
                                    label = {
                                        Text(navigationItem.label)
                                    },
                                    icon = {
                                        Icon(
                                            navigationItem.icon,
                                            contentDescription = navigationItem.label
                                        )
                                    },
                                    onClick = {
                                        navController.navigate(navigationItem.route) {
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) {paddingValues ->
                    NavHost(navController = navController, startDestination = startingScreen,modifier = Modifier.padding(paddingValues = paddingValues)){
                        composable("Login")      {LoginForm(service, nav = navController)}
                        composable("StartScreen") { StartScreen(service, nav = navController)}
                        composable("RiddleAnswer" ) { RiddleAnswer(service, nav = navController)}
                        composable("ActiveRiddle" ) { ActiveRiddle(service, nav = navController) }
                    }

                /*
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
                    BottomNavigationBar(navController)
                }
                */
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
}}


data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "StartScreen",
                icon = Icons.Filled.Home,
                route = Screens.Start.route
            ),
            BottomNavigationItem(
                label = "Search",
                icon = Icons.Filled.Search,
                route = Screens.RiddleAnswer.route
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Active.route
            ),
        )
    }
}

