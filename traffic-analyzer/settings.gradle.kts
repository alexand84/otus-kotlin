pluginManagement {
    includeBuild("../build-plugin")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "traffic-analyzer"

include(":api-v1")
include(":netflow-receiver")