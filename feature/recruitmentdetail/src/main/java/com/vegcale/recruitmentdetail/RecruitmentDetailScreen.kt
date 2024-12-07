package com.vegcale.recruitmentdetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vegcale.designsystem.theme.ForWantedlyTheme

@Composable
internal fun RecruitmentDetailScreen() {
    RecruitmentDetailScreenRoute()
}

@Composable
private fun RecruitmentDetailScreenRoute() {
    Text(text = "recruitment detail")
}


@Preview
@Composable
private fun RecruitmentDetailScreenPreview() {
    ForWantedlyTheme {
        RecruitmentDetailScreenRoute()
    }
}
