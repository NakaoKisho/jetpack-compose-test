package com.vegcale.recruitmentdetail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vegcale.recruitmentdetail.RecruitmentDetailScreen
import kotlinx.serialization.Serializable

@Serializable
data class RecruitmentDetailRoute(val id: String)

fun NavGraphBuilder.recruitmentDetailSection() {
    composable<RecruitmentDetailRoute> {
        RecruitmentDetailScreen()
    }
}
