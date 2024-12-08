package com.vegcale.projectdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.vegcale.core.model.ProjectDetail
import com.vegcale.designsystem.theme.ForWantedlyTheme
import com.vegcale.designsystem.theme.Typography

@Composable
internal fun ProjectDetailRoute(
    projectId: Int,
    viewModel: ProjectDetailViewModel = hiltViewModel(),
) {
    viewModel.updateDetail(projectId)
    val projectDetailUiState by viewModel.projectDetailUiState.collectAsStateWithLifecycle()

    ProjectDetailScreen(
        projectDetailUiState = projectDetailUiState
    )
}

@Composable
private fun ProjectDetailScreen(
    projectDetailUiState: ProjectDetailUiState = ProjectDetailUiState.Loading,
) {
    when (projectDetailUiState) {
        is ProjectDetailUiState.Loading,
        is ProjectDetailUiState.LoadFailed -> Unit

        is ProjectDetailUiState.Success ->
            ProjectDetail(
                detail = projectDetailUiState.projectDetail
            )
    }
}

@Composable
private fun ProjectDetail(
    modifier: Modifier = Modifier,
    detail: ProjectDetail,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            ),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = detail.image,
            contentDescription = "",
        )

        DetailBody(
            modifier = Modifier.padding(
                horizontal = 10.dp
            ),
            detail = detail,
        )
    }
}

@Composable
private fun DetailBody(
    modifier: Modifier = Modifier,
    detail: ProjectDetail,
) {
    Text(
        text = detail.title,
        modifier = modifier,
        style = Typography.titleLarge,
    )

    Text(
        text = detail.companyName,
        modifier = modifier.fillMaxWidth(),
        style = Typography.bodyMedium,
    )

    Text(
        text = detail.whatDescription,
        modifier = modifier,
    )

    Text(
        text = detail.whyDescription,
        modifier = modifier,
    )

    Text(
        text = detail.howDescription,
        modifier = modifier,
    )
}


@Preview
@Composable
private fun ProjectDetailScreenPreview() {
    ForWantedlyTheme {
        ProjectDetailScreen(
            projectDetailUiState = ProjectDetailUiState.Success(
                projectDetail = ProjectDetail(
                    title = "test title",
                    companyName = "test company name",
                    image = "https://www.google.co.jp/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png",
                    whatDescription = "test what description",
                    whyDescription = "test why description",
                    howDescription = "test how description",
                )
            )
        )
    }
}
