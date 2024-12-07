package com.vegcale.recruitment.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vegcale.recruitment.RecruitmentScreen
import com.vegcale.recruitmentdetail.navigation.recruitmentDetailSection
import kotlinx.serialization.Serializable

@Serializable
object RecruitmentRoute

@Serializable
object RecruitmentBaseRoute

fun NavGraphBuilder.recruitmentSection() {
    navigation<RecruitmentBaseRoute>(startDestination = RecruitmentRoute) {
        composable<RecruitmentRoute> {
            RecruitmentScreen()
        }
        recruitmentDetailSection()
    }
}
