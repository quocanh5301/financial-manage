package com.example.financialManagement.presentation.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financialManagement.navigation.Tab
import com.example.financialManagement.presentation.ui.compose.MyBottomNavBar

@Composable
fun BaseScreen(
    baseNavController: NavHostController = rememberNavController(),
    rootNavController : NavHostController
) {
    Scaffold(
        bottomBar = { MyBottomNavBar(baseNavController) }
    ) { paddingValues ->
        NavHost(
            navController = baseNavController,
            startDestination = Tab.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Tab.Home.route) { HomeScreen() }
//            composable(Tab.Search.route) { SearchScreen() }
//            composable(Tab.Profile.route) { ProfileScreen() }
//
        }
    }
}

