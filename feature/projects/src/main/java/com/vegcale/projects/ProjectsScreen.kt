package com.vegcale.projects

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.vegcale.core.model.Projects
import com.vegcale.designsystem.component.WantedlyTopAppBar
import com.vegcale.designsystem.theme.ForWantedlyTheme
import com.vegcale.feature.projects.R

@Composable
internal fun ProjectsRoute(
    viewModel: ProjectsViewModel = hiltViewModel(),
) {
    val queryUiState by viewModel.queryState.collectAsStateWithLifecycle()
    val searchUiState by viewModel.searchUiState.collectAsStateWithLifecycle()

    ProjectsScreen(
        queryUiState = queryUiState,
        searchUiState = searchUiState,
        updateProjectsQuery = viewModel::updateProjectsQuery,
        updateProjects = viewModel::updateProjects,
        pageNo = viewModel.pageNo,
        updatePageNo = viewModel::updatePageNo,
    )
}

@Composable
private fun ProjectsScreen(
    modifier: Modifier = Modifier,
    queryUiState: QueryUiState = QueryUiState.Loading,
    searchUiState: SearchUiState = SearchUiState.Loading,
    updateProjectsQuery: (String) -> Unit = {},
    updateProjects: (String, Int) -> Unit = { _, _ -> },
    pageNo: Int = 1,
    updatePageNo: (Int) -> Unit = {},
) {
    val snackbarHostState = remember { SnackbarHostState() }
    QuerySnackBar(
        snackbarHostState = snackbarHostState,
        queryUiState = queryUiState,
    )
    SearchSnackBar(
        snackbarHostState = snackbarHostState,
        searchUiState = searchUiState,
    )

    LaunchedEffect(key1 = queryUiState) {
        when (queryUiState) {
            is QueryUiState.Success -> {
                updateProjects(
                    queryUiState.query,
                    pageNo
                )
            }

            else -> Unit
        }
    }

    val currentQuery = if (queryUiState is QueryUiState.Success) {
        queryUiState.query
    } else {
        ""
    }

    Scaffold(
        topBar = {
            WantedlyTopAppBar(
                currentQuery = currentQuery,
                onSearch = { query ->
                    updateProjectsQuery(query)
                    val firstPageNo = 1
                    updatePageNo(firstPageNo)
                    updateProjects(query, pageNo)
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { paddingValues ->
        when (searchUiState) {
            is SearchUiState.Loading,
            is SearchUiState.LoadFailed -> Unit

            is SearchUiState.Success ->
                ProjectList(
                    modifier = modifier,
                    paddingValues = paddingValues,
                    projects = searchUiState.projects,
                )
        }
    }
}

@Composable
private fun QuerySnackBar(
    snackbarHostState: SnackbarHostState,
    queryUiState: QueryUiState,
) {
    val errorMessage = stringResource(id = R.string.ui_state_error_message)
    LaunchedEffect(snackbarHostState) {
        when (queryUiState) {
            is QueryUiState.LoadFailed -> {
                snackbarHostState.showSnackbar(
                    message = errorMessage
                )
            }

            else -> Unit
        }
    }
}

@Composable
private fun SearchSnackBar(
    snackbarHostState: SnackbarHostState,
    searchUiState: SearchUiState,
) {
    val errorMessage = stringResource(id = R.string.ui_state_error_message)
    LaunchedEffect(snackbarHostState) {
        when (searchUiState) {
            is SearchUiState.LoadFailed -> {
                snackbarHostState.showSnackbar(
                    message = errorMessage
                )
            }

            else -> Unit
        }
    }
}


@Composable
private fun ProjectList(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    projects: List<Projects>,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentPadding = PaddingValues(
            all = 10.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(
            count = projects.size
        ) { index ->
            val project = projects[index]

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.LightGray
                ),
            ) {
                Box {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                all = 8.dp
                            )
                    ) {
                        AsyncImage(
                            model = project.image,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth(),
                        )
                        Text(text = project.companyName)
                        Text(text = project.title)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ProjectsScreenPreview() {
    ForWantedlyTheme {
        ProjectsScreen()
    }
}
