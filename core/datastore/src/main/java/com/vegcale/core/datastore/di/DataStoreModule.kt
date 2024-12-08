package com.vegcale.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.vegcale.core.datastore.ProjectsQuery
import com.vegcale.core.datastore.ProjectsQuerySerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    internal fun providesProjectsQueryDataStore(
        @ApplicationContext context: Context,
        projectsQuerySerializer: ProjectsQuerySerializer,
    ): DataStore<ProjectsQuery> =
        DataStoreFactory.create(
            serializer = projectsQuerySerializer,
        ) {
            context.dataStoreFile("projects_query.pb")
        }
}
