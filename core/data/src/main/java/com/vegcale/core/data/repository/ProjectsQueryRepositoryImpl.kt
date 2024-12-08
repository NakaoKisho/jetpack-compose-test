package com.vegcale.core.data.repository

import androidx.datastore.core.DataStore
import com.vegcale.core.datastore.ProjectsQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException
import javax.inject.Inject

class ProjectsQueryRepositoryImpl @Inject constructor(
    private val projectsQueryDataStore: DataStore<ProjectsQuery>,
) : ProjectsQueryRepository {
    override val projectsQueryFlow: Flow<ProjectsQuery> = projectsQueryDataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(ProjectsQuery.getDefaultInstance())
            } else {
                throw exception
            }
        }

    override suspend fun updateProjectsQuery(query: String) {
        projectsQueryDataStore.updateData { currentQuery ->
            currentQuery.toBuilder().setQuery(query).build()
        }
    }
}
