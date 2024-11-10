/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this 
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

package ru.bampernn.convention

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.configure
import ru.bampernn.convention.utils.getLibrary
import ru.bampernn.convention.utils.pluginId
import ru.bampernn.convention.utils.toArtifact

class DetektCustomization: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply(pluginId("detekt"))
            }
            dependencies {
                add(
                    "detektPlugins",
                    getLibrary("detekt-compose").toArtifact()
                )
                add(
                    "detektPlugins",
                    getLibrary("detekt-formatting").toArtifact()
                )
            }
            extensions.configure<DetektExtension> {
                buildUponDefaultConfig = true
                allRules = true
                config.setFrom("${rootProject.projectDir}/build-logic/config/detekt.yml")
                autoCorrect = true
            }
            tasks.withType(Detekt::class.java) {
                autoCorrect = true
            }
        }
    }
}