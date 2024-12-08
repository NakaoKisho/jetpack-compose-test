package com.vegcale.core.data.repository

import com.vegcale.core.model.ProjectDetail
import com.vegcale.core.model.Projects

interface ProjectsRepository {
    suspend fun getProjects(q: String, page: Int): List<Projects>

    suspend fun getProjectById(id: Int): ProjectDetail
}
