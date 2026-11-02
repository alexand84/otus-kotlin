dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

rootProject.name = "otus-kotlin"

includeBuild("ok-marketplace-be")
includeBuild("traffic-analyzer")