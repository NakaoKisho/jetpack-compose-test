package com.vegcale.projects.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vegcale.projectdetail.navigation.projectDetailSection
import com.vegcale.projects.ProjectsRoute
import kotlinx.serialization.Serializable

@Serializable
object ProjectRoute

@Serializable
object ProjectBaseRoute

fun NavGraphBuilder.projectSection(
    onProjectClick: (Int) -> Unit,
) {
    navigation<ProjectBaseRoute>(startDestination = ProjectRoute) {
        composable<ProjectRoute> {
            ProjectsRoute(
                onProjectClick = onProjectClick,
            )
        }
        projectDetailSection()
    }
}
