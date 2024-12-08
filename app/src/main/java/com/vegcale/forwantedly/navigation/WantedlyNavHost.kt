package com.vegcale.forwantedly.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.vegcale.forwantedly.ui.WantedlyAppState
import com.vegcale.projectdetail.navigation.navigateToProjectDetail
import com.vegcale.projects.navigation.ProjectBaseRoute
import com.vegcale.projects.navigation.projectSection

@Composable
fun WantedlyNavHost(
    wantedlyAppState: WantedlyAppState,
    modifier: Modifier = Modifier,
) {
    val navController = wantedlyAppState.navController

    NavHost(
        navController = navController,
        startDestination = ProjectBaseRoute,
        modifier = modifier,
    ) {
        projectSection(
            onProjectClick = navController::navigateToProjectDetail,
        )
    }
}