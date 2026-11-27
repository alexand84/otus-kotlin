plugins {
    id("build-jvm")
    alias(libs.plugins.openapi.generator)
}

dependencies {
    implementation(libs.jackson.kotlin)
    implementation(libs.jackson.datatype)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.junit.jupiter)
}

tasks.test {
    useJUnitPlatform()
}

val specFile = layout.projectDirectory.file("src/main/resources/specs/spec-api-v1.yaml")
val generatedSources = layout.buildDirectory.dir("generate-resources/main/src/main/kotlin")

openApiGenerate {
    val openapiGroup = "${rootProject.group}.api.v1"
    generatorName.set("kotlin")
    packageName.set(openapiGroup)
    apiPackage.set("$openapiGroup.api")
    modelPackage.set("$openapiGroup.models")
    invokerPackage.set("$openapiGroup.invoker")

    inputSpec.set(specFile.asFile.absolutePath)

    globalProperties.put("models", "")

    generateModelTests.set(false)
    generateModelDocumentation.set(false)
    cleanupOutput.set(true)

    configOptions.set(
        mapOf(
            "dateLibrary" to "java",
            "enumPropertyNaming" to "UPPERCASE",
            "serializationLibrary" to "jackson",
            "collectionType" to "list"
        )
    )
}

openApiValidate {
    inputSpec.set(specFile.asFile.absolutePath)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir(generatedSources)
}

tasks.named("compileKotlin") {
    dependsOn(tasks.named("openApiGenerate"))
}

tasks.named("check") {
    dependsOn(tasks.named("openApiValidate"))
}