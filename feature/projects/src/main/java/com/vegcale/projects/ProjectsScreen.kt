package com.vegcale.projects

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
    )
}

@Composable
private fun ProjectsScreen(
    modifier: Modifier = Modifier,
    queryUiState: QueryUiState = QueryUiState.Loading,
    searchUiState: SearchUiState = SearchUiState.Loading,
    updateProjectsQuery: (String) -> Unit = {},
    updateProjects: (String, Int) -> Unit = { _, _ -> },
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

    when (searchUiState) {
        is SearchUiState.Loading,
        is SearchUiState.LoadFailed -> Unit

        is SearchUiState.Success ->
            Body(
                modifier = modifier,
                queryUiState = queryUiState,
                updateProjectsQuery = updateProjectsQuery,
                updateProjects = updateProjects,
                snackbarHostState = snackbarHostState,
                searchUiState = searchUiState,
            )
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
private fun Body(
    modifier: Modifier = Modifier,
    queryUiState: QueryUiState,
    updateProjectsQuery: (String) -> Unit,
    updateProjects: (String, Int) -> Unit,
    snackbarHostState: SnackbarHostState,
    searchUiState: SearchUiState.Success,
) {
    val currentQuery = if (queryUiState is QueryUiState.Success) {
        queryUiState.query
    } else {
        ""
    }
    val projects = searchUiState.projects

    Scaffold(
        topBar = {
            WantedlyTopAppBar(
                currentQuery = currentQuery,
                onSearch = { query ->
                    updateProjectsQuery(query)

                    val pageCount = 1
                    updateProjects(query, pageCount)
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = 10.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(
                count = projects.size
            ) {
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
                            Image(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Text(text = "title")
                            Text(text = "company name")
                        }
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
