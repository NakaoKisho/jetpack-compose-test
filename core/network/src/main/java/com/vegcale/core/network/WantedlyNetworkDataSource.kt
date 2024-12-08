package com.vegcale.core.network

import com.vegcale.core.network.model.NetworkProjectDetail
import com.vegcale.core.network.model.NetworkProjects

interface WantedlyNetworkDataSource {
    suspend fun getProjects(q: String, page: Int): List<NetworkProjects>

    suspend fun getProjectById(id: Int): NetworkProjectDetail
}