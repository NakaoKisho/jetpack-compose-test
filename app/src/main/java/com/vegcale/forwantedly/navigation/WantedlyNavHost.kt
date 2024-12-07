package com.vegcale.forwantedly.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.vegcale.forwantedly.ui.WantedlyAppState
import com.vegcale.projects.navigation.RecruitmentBaseRoute
import com.vegcale.projects.navigation.recruitmentSection

@Composable
fun WantedlyNavHost(
    wantedlyAppState: WantedlyAppState,
    modifier: Modifier = Modifier,
) {
    val navController = wantedlyAppState.navController

    NavHost(
        navController = navController,
        startDestination = RecruitmentBaseRoute,
        modifier = modifier,
    ) {
        recruitmentSection()
    }
}