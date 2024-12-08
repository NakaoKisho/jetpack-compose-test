package com.vegcale.projects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vegcale.core.data.repository.ProjectsQueryRepository
import com.vegcale.core.data.repository.ProjectsRepository
import com.vegcale.core.model.Projects
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface SearchUiState {
    data object Loading: SearchUiState
    data object LoadFailed: SearchUiState
    data class Success(val projects: List<Projects>): SearchUiState
}

@HiltViewModel
class ProjectsViewModel @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    private val projectsQueryRepository: ProjectsQueryRepository,
) : ViewModel() {
    val searchUiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState.Loading)

    val queryState: StateFlow<QueryUiState> =
        projectsQueryRepository
            .projectsQueryFlow
            .map { projectsQuery ->
                try {
                    QueryUiState.Success(
                        query = projectsQuery.query,
                    )
                } catch (e: Exception) {
                    QueryUiState.LoadFailed
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = QueryUiState.Loading,
            )

    fun updateProjects(query: String, pageCount: Int) {
        viewModelScope.launch {
            searchUiState.update {
                try {
                    val projects = projectsRepository.getProjects(query, pageCount)
                    SearchUiState.Success(
                        projects = projects,
                    )
                } catch (e: Exception) {
                    SearchUiState.LoadFailed
                }
            }
        }
    }

    fun updateProjectsQuery(query: String) {
        viewModelScope.launch {
            projectsQueryRepository.updateProjectsQuery(query)
        }
    }
}
