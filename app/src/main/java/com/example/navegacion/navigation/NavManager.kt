package com.example.navegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacion.views.DetailView
import com.example.navegacion.views.HomeView
import com.example.navegacion.views.NewView

@Composable
fun NavManager () {
    val navController = rememberNavController ()
    NavHost (
        navController = navController,
        startDestination = "Home"
    ) {
        composable (
            route = "Home"
        ) {
            HomeView ( navController )
        }

        composable (
            route = "Detail/{id}/?{opcional}",
            arguments = listOf (
                navArgument ( name = "id" ) { type = NavType.IntType },
                navArgument ( name = "opcional") { type = NavType.StringType },
            )
        ) {
            val id = it.arguments?.getInt( "id" ) ?: 0
            val opcional = it.arguments?.getString( "opcional" ) ?: ""
            DetailView ( navController, id, opcional )
        }

        composable (
            route = "New/{id}/?{opcional}",
            arguments = listOf (
                navArgument( name = "id" ) { type = NavType.IntType },
                navArgument( name = "opcional" ) { type = NavType.StringType },
            )
        ) {
            val id = it.arguments?.getInt( "id" ) ?: 0
            val opcional = it.arguments?.getString( "opcional" ) ?: ""
            NewView ( navController, id, opcional )
        }
    }
}