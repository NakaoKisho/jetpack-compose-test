package com.vegcale.projectdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.vegcale.projectdetail.ProjectDetailRoute
import kotlinx.serialization.Serializable

@Serializable
data class ProjectDetail(val projectId: Int)

fun NavController.navigateToProjectDetail(projectId: Int, navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = ProjectDetail(projectId = projectId)) {
        navOptions()
    }
}

fun NavGraphBuilder.projectDetailSection() {
    composable<ProjectDetail> { backStackEntry ->
        val projectDetail: ProjectDetail = backStackEntry.toRoute()

        ProjectDetailRoute(
            projectId = projectDetail.projectId
        )
    }
}
