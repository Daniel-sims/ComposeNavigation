import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("example.android.library")
                apply("example.android.hilt")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {

                // Compose specifics
                add("implementation", libs.findLibrary("compose.ui").get())
                add("implementation", libs.findLibrary("compose.ui.tooling").get())
                add("implementation", libs.findLibrary("compose.ui.tooling.preview").get())
                add("implementation", libs.findLibrary("compose.material.three").get())
                add("implementation", libs.findLibrary("compose.constraintlayout").get())

                // Navigation
                add("implementation", libs.findLibrary("compose.navigation").get())
                add("implementation", libs.findLibrary("accompanist.navigation.animation").get())

                // Hilt
                add("implementation", libs.findLibrary("hilt.navigation.compose").get())

                // Androidx
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime.compose").get())

                // Unit Testing
                add("testImplementation", kotlin("test"))
                add("testImplementation", libs.findLibrary("truth").get())
                add("testImplementation", libs.findLibrary("mockk").get())

                // UI Testing
                add("androidTestImplementation", kotlin("test"))
            }
        }
    }
}