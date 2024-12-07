package com.vegcale.core.network

import com.vegcale.core.network.model.NetworkProjects

interface WantedlyNetworkDataSource {
    suspend fun getProjects(q: String, page: Int): List<NetworkProjects>
}