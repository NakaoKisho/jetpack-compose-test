package com.vegcale.projectdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vegcale.core.data.repository.ProjectsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectDetailViewModel @Inject constructor(
    private val projectsRepository: ProjectsRepository,
) : ViewModel() {
    private val tag = "ProjectDetailViewModel"
    val projectDetailUiState: MutableStateFlow<ProjectDetailUiState> =
        MutableStateFlow(ProjectDetailUiState.Loading)

    fun updateDetail(id: Int) {
        viewModelScope.launch {
            projectDetailUiState.update {
                try {
                    val projectDetail = projectsRepository.getProjectById(id)
                    ProjectDetailUiState.Success(
                        projectDetail = projectDetail,
                    )
                } catch (e: Exception) {
                    Log.e(tag, e.toString())
                    ProjectDetailUiState.LoadFailed
                }
            }
        }
    }
}

sealed interface ProjectDetailUiState {
    data object Loading: ProjectDetailUiState
    data object LoadFailed: ProjectDetailUiState
    data class Success(
        val projectDetail: com.vegcale.core.model.ProjectDetail
    ): ProjectDetailUiState
}
