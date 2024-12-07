package com.vegcale.core.network.di

import com.vegcale.core.network.WantedlyNetworkDataSource
import com.vegcale.core.network.retrofit.RetrofitWantedlyNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Binds
    internal abstract fun bindWantedlyNetwork(
        wantedlyNetwork: RetrofitWantedlyNetwork
    ): WantedlyNetworkDataSource
}