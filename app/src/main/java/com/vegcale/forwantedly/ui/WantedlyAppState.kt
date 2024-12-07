package com.vegcale.forwantedly.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberWantedlyAppState(
    navController: NavHostController = rememberNavController()
): WantedlyAppState {
    return remember(navController) {
        WantedlyAppState(
            navController = navController
        )
    }
}

class WantedlyAppState(
    val navController: NavHostController,
) {
}