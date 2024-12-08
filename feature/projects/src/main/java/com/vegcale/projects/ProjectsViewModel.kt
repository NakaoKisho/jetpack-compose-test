package com.vegcale.projects

import android.util.Log
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

@HiltViewModel
class ProjectsViewModel @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    private val projectsQueryRepository: ProjectsQueryRepository,
) : ViewModel() {
    private val tag = "ProjectsViewModel"
    private var _pageNo = 1
    val searchUiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState.Loading)
    val pageNo = _pageNo

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

    fun updatePageNo(pageNo: Int) {
        _pageNo = pageNo
    }

    fun updateProjects(query: String, pageCount: Int) {
        viewModelScope.launch {
            searchUiState.update {
                try {
                    val projects = projectsRepository.getProjects(query, pageCount)
                    SearchUiState.Success(
                        projects = projects,
                    )
                } catch (e: Exception) {
                    Log.e(tag, e.toString())
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

sealed interface SearchUiState {
    data object Loading: SearchUiState
    data object LoadFailed: SearchUiState
    data class Success(val projects: List<Projects>): SearchUiState
}
