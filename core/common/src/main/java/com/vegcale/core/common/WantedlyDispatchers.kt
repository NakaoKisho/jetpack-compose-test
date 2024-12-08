package com.vegcale.core.common

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val wantedlyDispatchers: WantedlyDispatchers)

enum class WantedlyDispatchers {
    Default,
    IO,
}
