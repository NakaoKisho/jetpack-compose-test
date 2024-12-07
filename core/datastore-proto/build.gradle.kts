plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.vegcale.core.datastore.proto"
    compileSdk = 35
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:4.29.1"
    }

    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                register("java") {
                    option("lite")
                }
                register("kotlin") {
                    option("lite")
                }
            }
        }
    }
}

//androidComponents.beforeVariants {
//    android.sourceSets.getByName(it.name) {
//        val buildDir = layout.buildDirectory.get().asFile
//
//        java.srcDir(buildDir.resolve("generated/source/proto/${it.name}/java"))
//        kotlin.srcDir(buildDir.resolve("generated/source/proto/${it.name}/kotlin"))
//    }
//}
//println("test nakao source: ${sourceSets.size}")
//android.sourceSets.getByName("debug") {
//    proto {
//        srcDir(layout.buildDirectory)
//    }
//}
//println("test nakao source: ${sourceSets}")
//sourceSets["main"].proto {
//    srcDir("${layout.buildDirectory}")
//}


dependencies {
    api(libs.protobuf.javalite)
}
