package com.example.riddlemiddle.riddlemiddleapp.NavCollection


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.*
import androidx.compose.animation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.*
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.*
import androidx.compose.material3.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.tooling.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.*
import androidx.compose.ui.res.*
import androidx.compose.ui.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.riddlemiddle.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.riddlemiddle.SelectionActivity.listTest.ListTestCardScreen
import com.example.riddlemiddle.navTest.HomeScreen
import com.example.riddlemiddle.navTest.ProfileScreen
import com.example.riddlemiddle.navTest.SearchScreen
import com.example.riddlemiddle.riddlemiddleapp.NavCollection.Screens
import androidx.navigation.NavGraph.Companion.findStartDestination as findStartDestination1





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(views: List<@Composable (NavController) -> Unit>) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
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
                                popUpTo(id = navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Screens.Home.route) {
                HomeScreen()
            }
            composable(Screens.ListTestCard.route) {
                ListTestCardScreen(navController)
            }
            composable(Screens.Search.route) {
                ProfileScreen(navController)
            }
            composable(Screens.Profile.route) {
                SearchScreen(navController)
            }
            // Add a composable for the "search_screen" route if needed.
        }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomNavigationBarPreview() {
    val dummyViews: List<@Composable (NavController) -> Unit> = listOf(
        { navController -> HomeScreen() },
        { navController -> ListTestCardScreen(navController) },
        { navController -> Text("Profile Content") }
    )

    BottomNavigationBar(views = dummyViews)
}



