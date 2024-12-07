package com.vegcale.core.network.retrofit

import com.vegcale.core.network.WantedlyNetworkDataSource
import com.vegcale.core.network.model.NetworkProjects
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitWantedlyNetworkApi {
    @GET("projects")
    suspend fun getProjects(
        @Query("q") q: String,
        @Query("page") page: Int,
    ): WantedlyResponse<List<NetworkProjects>>
}

@Serializable
private data class WantedlyResponse<T>(
    val data: T,
)

@Singleton
internal class RetrofitWantedlyNetwork @Inject constructor(
    networkJson: Json,
) : WantedlyNetworkDataSource {
    private val apiUrl = "https://www.wantedly.com/api" // todo buildconfig
    private val apiVersion = "/v1" // todo buildconfig
    private val networkApi = Retrofit.Builder()
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(apiUrl + apiVersion)
        .build()
        .create(RetrofitWantedlyNetworkApi::class.java)

    override suspend fun getProjects(q: String, page: Int) =
        networkApi.getProjects(q = q, page = page).data
}
