package com.vegcale.projects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vegcale.core.data.repository.ProjectsQueryRepository
import com.vegcale.core.data.repository.ProjectsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    private val projectsQueryRepository: ProjectsQueryRepository,
) : ViewModel() {
    val searchResultUiState =
        projectsQueryRepository
            .projectsQueryFlow
            .map { projectsQuery ->
                try {
                    SearchResultUiState.Success(
                        query = projectsQuery.query,
                    )
                } catch (e: Exception) {
                    SearchResultUiState.LoadFailed
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = SearchResultUiState.Loading,
            )

    fun getProjects(query: String) {
        viewModelScope.launch {
            projectsRepository.getProjects(query, 1)
        }
    }

    fun updateProjectsQuery(query: String) {
        viewModelScope.launch {
            projectsQueryRepository.updateProjectsQuery(query)
        }
    }
}
