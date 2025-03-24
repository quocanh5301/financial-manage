package com.example.financialManagement.presentation.ui.compose

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.financialManagement.navigation.Tab

@Composable
fun MyBottomNavBar(navController: NavController) {
    val screens = listOf(Tab.Home, Tab.Search, Tab.Profile, Tab.Settings)

    BottomAppBar {
        screens.forEach { screen ->
            IconButton(
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true//qa need?
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(imageVector = screen.icon, contentDescription = screen.title)
            }
        }
    }
}
