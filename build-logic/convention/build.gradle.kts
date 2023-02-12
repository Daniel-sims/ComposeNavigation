plugins {
    `kotlin-dsl`
}

group = "com.example.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {

        // region Library
        register("androidLibraryCompose") {
            id = "example.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "example.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "example.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        // endregion Library

        // region Application
        register("androidApplication") {
            id = "example.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "example.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        // endregion Application

        register("androidHilt") {
            id = "example.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}
