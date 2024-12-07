package com.vegcale.core.data.repository

import com.vegcale.core.model.Projects

interface ProjectsRepository {
    suspend fun getProjects(q: String, page: Int): List<Projects>
}
