package com.vegcale.core.network.retrofit

import com.vegcale.core.network.BuildConfig
import com.vegcale.core.network.WantedlyNetworkDataSource
import com.vegcale.core.network.model.NetworkProjectDetail
import com.vegcale.core.network.model.NetworkProjects
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitWantedlyNetworkApi {
    @GET("projects")
    suspend fun getProjects(
        @Query("q") q: String,
        @Query("page") page: Int,
    ): WantedlyResponse<List<NetworkProjects>>

    @GET("projects/{id}")
    suspend fun getProjectById(
        @Path("id") id: Int,
    ): WantedlyResponse<NetworkProjectDetail>
}

@Serializable
private data class WantedlyResponse<T>(
    val data: T,
)

@Singleton
internal class RetrofitWantedlyNetwork @Inject constructor(
    networkJson: Json,
) : WantedlyNetworkDataSource {
    private val baseUrl = BuildConfig.API_URL + BuildConfig.API_VERSION
    private val networkApi = Retrofit.Builder()
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(baseUrl)
        .build()
        .create(RetrofitWantedlyNetworkApi::class.java)

    override suspend fun getProjects(q: String, page: Int) =
        networkApi.getProjects(q = q, page = page).data

    override suspend fun getProjectById(id: Int) =
        networkApi.getProjectById(id = id).data
}
