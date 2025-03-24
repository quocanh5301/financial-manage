package com.example.financialManagement.navigation

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.financialManagement.presentation.ui.screen.BaseScreen
import com.example.financialManagement.presentation.ui.screen.LoginScreen
import com.example.financialManagement.presentation.viewmodel.RootViewModel
import com.google.gson.Gson

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    val preferencesManager = hiltViewModel<RootViewModel>().preferencesManager
    val user by preferencesManager.userFlow.collectAsState(initial = null)

    val startDestination = if (user == null) Screen.Login.route else Screen.Base.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                navController = navController
            )
        }
        composable(Screen.Base.route) {
            BaseScreen(
                rootNavController = navController
            )
        }
//        composable(
//            Screen.Recipe.route + "/{category}",
//            arguments = listOf(
//                navArgument("category") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                    nullable = true
//                },
//            )
//        ) {
//            //send through arguments
//            val categoryJSON = it.arguments?.getString("category")
//            if (categoryJSON != null) {
//                val categoryFromJson = Gson().fromJson(categoryJSON, Category::class.java)
//                RecipeScreen(
//                    categoryName = categoryFromJson.strCategory,
//                    navController = navController
//                )
//            }
//        }
    }
}

sealed class Screen(val route: String, ) {
    data object Login : Screen("login_screen")
    data object Base : Screen("base_screen")
}

sealed class Tab(val route: String, val icon: ImageVector, val title: String) {
    data object Home : Tab("home", Icons.Default.Home, "Home")
    data object Search : Tab("search", Icons.Default.Search, "Search")
    data object Profile : Tab("profile", Icons.Default.Person, "Profile")
    data object Settings : Tab("settings", Icons.Default.Settings, "Settings")
}


