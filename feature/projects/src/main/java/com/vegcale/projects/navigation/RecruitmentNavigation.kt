package com.vegcale.projects.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vegcale.projects.ProjectsRoute
import com.vegcale.recruitmentdetail.navigation.recruitmentDetailSection
import kotlinx.serialization.Serializable

@Serializable
object RecruitmentRoute

@Serializable
object RecruitmentBaseRoute

fun NavGraphBuilder.recruitmentSection() {
    navigation<RecruitmentBaseRoute>(startDestination = RecruitmentRoute) {
        composable<RecruitmentRoute> {
            ProjectsRoute()
        }
        recruitmentDetailSection()
    }
}
