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

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginCollection: Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply {
            apply("detekt-customized")
        }
    }
}