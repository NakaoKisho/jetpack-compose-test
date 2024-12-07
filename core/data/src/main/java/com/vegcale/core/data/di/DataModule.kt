package com.vegcale.core.data.di

import com.vegcale.core.data.repository.ProjectsRepository
import com.vegcale.core.data.repository.ProjectsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsProjectsRepository(
        projectsRepositoryImpl: ProjectsRepositoryImpl
    ): ProjectsRepository
}