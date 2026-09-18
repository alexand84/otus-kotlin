dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

pluginManagement {
    plugins {
        val kotlinVersion = providers.gradleProperty("kotlinVersion").get()
        kotlin("jvm") version kotlinVersion
    }
}

include(":m1l1-first")

rootProject.name = "otus-kotlin"