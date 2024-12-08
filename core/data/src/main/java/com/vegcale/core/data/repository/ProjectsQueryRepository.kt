package com.vegcale.core.data.repository

import com.vegcale.core.datastore.ProjectsQuery
import kotlinx.coroutines.flow.Flow

interface ProjectsQueryRepository {
    val projectsQueryFlow: Flow<ProjectsQuery>

    suspend fun updateProjectsQuery(query: String)
}