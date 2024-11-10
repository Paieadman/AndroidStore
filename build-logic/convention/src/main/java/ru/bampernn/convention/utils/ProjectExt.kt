/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this 
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

package ru.bampernn.convention.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension

fun Project.getLibrary(
    name: String,
    catalogName: String = "libs"
): Triple<String, String, String> = extensions
    .getByType(VersionCatalogsExtension::class.java)
    .named(catalogName)
    .findLibrary(name)
    .get()
    .get()
    .let {
        Triple(
            first = it.group,
            second = it.name,
            third = it.version.orEmpty(),
        )
    }

fun Project.pluginId(
    name: String,
    catalogName: String = "libs"
): String = extensions
        .getByType(VersionCatalogsExtension::class.java)
        .named(catalogName)
        .findPlugin(name)
        .get()
        .get()
        .pluginId
