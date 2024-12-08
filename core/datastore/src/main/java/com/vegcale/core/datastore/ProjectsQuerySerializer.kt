package com.vegcale.core.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class ProjectsQuerySerializer @Inject constructor() : Serializer<ProjectsQuery> {
    override val defaultValue: ProjectsQuery = ProjectsQuery.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ProjectsQuery {
        try {
            return ProjectsQuery.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: ProjectsQuery, output: OutputStream) {
        t.writeTo(output)
    }
}
