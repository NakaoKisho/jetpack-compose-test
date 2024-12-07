pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ForWantedly"
include(":app")
include(":feature")
include(":feature:projects")
include(":core")
include(":core:designsystem")
include(":feature:recruitmentdetail")
include(":core:network")
include(":core:data")
include(":core:model")
include(":core:datastore-proto")
include(":core:datastore")
