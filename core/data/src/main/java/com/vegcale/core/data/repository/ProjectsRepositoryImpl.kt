package com.vegcale.core.data.repository

import com.vegcale.core.model.Projects
import com.vegcale.core.network.WantedlyNetworkDataSource
import javax.inject.Inject

internal class ProjectsRepositoryImpl @Inject constructor(
    private val network: WantedlyNetworkDataSource
) : ProjectsRepository {
    override suspend fun getProjects(q: String, page: Int): List<Projects> {
        val rawProjects = network.getProjects(q = q, page = page)

        return rawProjects.map { project ->
            Projects(
                id = project.id,
                title = project.title,
                image = project.image.original,
                companyName = project.company.name,
            )
        }
    }
}