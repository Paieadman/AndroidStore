/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {

    `kotlin-dsl`
//    id("org.gradle.kotlin.kotlin-dsl") version "5.1.2"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.bundles.detekt)
}

gradlePlugin  {
    plugins {
        plugIn(
            id = "detekt-customized",
            implementationClass = "ru.bampernn.convention.DetektCustomization"
        )
        plugIn(
            id = "plugin-collection",
            implementationClass = "ru.bampernn.convention.PluginCollection"
        )
    }

}

fun NamedDomainObjectContainer<PluginDeclaration>.plugIn(
    id: String,
    implementationClass: String,
) {
    register(id) {
        this.id = id
        this.implementationClass = implementationClass
    }
}
