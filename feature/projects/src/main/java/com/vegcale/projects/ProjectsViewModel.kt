package com.vegcale.projects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vegcale.core.data.repository.ProjectsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor(
    private val projectsRepository: ProjectsRepository
) : ViewModel() {
    fun getProjects() {
        viewModelScope.launch {
            projectsRepository.getProjects("", 1)
        }
    }
}
