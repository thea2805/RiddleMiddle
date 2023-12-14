package com.example.riddlemiddle.riddlemiddleapp.NavCollection

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.riddlemiddle.SelectionActivity.listTest.ListTestCardScreen
import com.example.riddlemiddle.navTest.BottomNavigationItem
import com.example.riddlemiddle.navTest.HomeScreen
import com.example.riddlemiddle.navTest.ProfileScreen
import com.example.riddlemiddle.navTest.SearchScreen



data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = "Search",
                icon = Icons.Filled.Search,
                route = Screens.Search.route
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Profile.route
            ),
            BottomNavigationItem(
                label = "TestListCard",
                icon = Icons.Filled.AccountBalanceWallet,
                route = Screens.ListTestCard.route
            ),
        )
    }
}

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Search : Screens("search_screen")
    object Profile : Screens("profile_screen")
    object ListTestCard : Screens("ListTestCard_screen")


}